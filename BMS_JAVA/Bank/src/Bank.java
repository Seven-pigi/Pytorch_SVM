
/*
 *银行类
 */
public class Bank {

    //存储所有银行账户
    static Account[] accounts=new Account[100];
    //当前的账户的数量
    static int count=0;

    //开户方法
    public static boolean register(Account account){
        if(count<100){
            accounts[count++]=account;
            return true;
        }
        return false;
    }

    //登录

    public  static Account login(long id, String password) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getId() == id
                    && accounts[i].getPassword().equals(password)) {
                return accounts[i];
            }
        }
        return null;
    }

    //统计所有账户总贷款额
    public static double getTotalLoan(){
        double sum=0;
        for(int i=0;i<count;i++){
            //判断可贷款账户
            if(accounts[i] instanceof ILoanable){
                ILoanable  loanAccount =(ILoanable)accounts[i];
                sum += loanAccount.getLoan();
            }
        }
        return sum;
    }

    //根据账户号来查询账户，判断账户是否存在
    public static Account findById(long id){
        for(int i=0;i<count;i++){
            if(accounts[i].getId()==id){
                return accounts[i];
            }
        }
        return null;
    }

}

