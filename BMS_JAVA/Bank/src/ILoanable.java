

public interface ILoanable {

    //贷款
    boolean requestLoan(double money);

    //还贷
    boolean payLoan(double money);

    //获取贷款总额
    double getLoan();

}

