
/*
 * 储蓄账户类：继承自Account
 */
public class SavingAccount extends Account{

    @Override
    public boolean withdraw(double money) {

        double balance=getBalance();

        if(balance >= money){
            setBalance(balance-money);
            return true;
        }
        return false;
    }

}

