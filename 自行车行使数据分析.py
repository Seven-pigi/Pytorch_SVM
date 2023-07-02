import pandas as pd
import matplotlib.pyplot as plt

# pd.set_option('display.mpl_style','default')
plt.rcParams['figure.figsize']=(15,5)
# sep分割符 parse_dates解析日期列
broken_df = pd.read_csv('bikes.csv',encoding='latin1',sep=';',parse_dates=['Date'],dayfirst=True,index_col='Date')
broken_df['Berri 1'].plot(figsize=(15,10))
# plt.show()

berri_bike = broken_df[['Berri 1']].copy()
# print(berri_bike.index.weekday)


berri_bike.loc[:,'weekday'] = berri_bike.index.weekday
#第十四步 接下来我们就可以把普通日作为一个统计日继续骑行人数的统计了
weekday_counts = berri_bike.groupby('weekday').aggregate(sum)


#第十五步   这时候我们会发现通过0、1、2、3、4、5、6这样的数字很难记住其对应的日子，可以通过以下方法修改。
weekday_counts.index = ['Monday','Tuesday','Wednesday','Thurday','Friday','Saturday','Sunday']
print(weekday_counts)

#第十六步 通过直方图来看统计情况：可以发现蒙特利尔似乎是一个喜欢使用自行车作为通勤工具的城市，因为人们在工作日也大量地使用自行车。
weekday_counts.plot(kind='bar')
plt.show()