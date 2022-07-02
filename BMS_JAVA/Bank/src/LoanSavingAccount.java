
/*
 *贷款的储蓄账户类： 继承自SavingAccount类:实现ILoanable接口
 */
public class LoanSavingAccount extends SavingAccount implements ILoanable {

    //我已经贷款的数目
    private double loanAmount;

    @Override
    public boolean requestLoan(double money) {
        this.loanAmount += money;
        return true;
    }

    @Override
    public boolean payLoan(double money) {
        double balance=getBalance();
        if(balance >= money){
            setBalance(balance-money);
            loanAmount-=money;
            return true;
        }
        return false;
    }

    @Override
    public double getLoan() {

        return this.loanAmount;
    }

}

