import pandas as pd
import matplotlib.pyplot as plt
complaints = pd.read_csv('311-service-requests.csv')
#第三步  选择某一列并查看前5个元素
complaints['Complaint Type'][:5]
#第四步  选择多列并查看前5列
complaints[['Complaint Type','Borough']][:5]
# 某一列的前五个元素
print(complaints['Complaint Type'][:5])
# 分析哪一个区的噪声投诉最多
complaint_counts = complaints['Complaint Type'].value_counts()
complaint_counts[:10].plot(kind='bar')
# plt.show()

is_noise = complaints['Complaint Type'] == "Noise-Street/Side-walk"

print(is_noise[:5])
# 使用这个bool序列来选择数据中的对应记录
noise_complains = complaints[is_noise]
noise_complains[:3]

print(complaints.head(5))
# 统计Borough列中哪个值出现次数最多。
noise_complains['Borough'].value_counts()
#  计算噪声投诉占总数的百分比
noise_complaint_counts = noise_complains['Borough'].value_counts()
complaint_counts = complaints['Borough'].value_counts()
percent = noise_complaint_counts / complaint_counts * 100
percent
#画出噪声投诉最多的区域
percent.plot(kind='bar')
plt.show()