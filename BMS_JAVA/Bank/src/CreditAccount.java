/*
 * 信用账户类：继承自Account
 */
public class CreditAccount extends Account{

    //特有属性：透支额度
    private double ceiling;

    @Override
    public boolean withdraw(double money) {
        double balance=getBalance();
        //取款金额小于等于（账户余额+可透支额度）
        if(balance+ceiling >= money){
            setBalance(balance-money);
            return true;
        }
        return false;
    }

    /*
     * getter和setter
     */

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

}

