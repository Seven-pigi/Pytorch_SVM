import java.util.Scanner;

//账户菜单类
public class AcccountMenu {
    private Scanner input = new Scanner(System.in);
    private Account account;//表示当前登录的账户

    public AcccountMenu(Account account) {
        super();
        this.account = account;
    }
    //显示账户主菜单
    public void showMainMenu(){
        System.out.println("============================================================");
        System.out.println("提示：：(1.存款 2.取款 3.查询余额 4.转账 5.贷款 6.还款 7.修改密码 8.注销):");
        System.out.println("============================================================");
        System.out.print("请选择：");

        int choice = input.nextInt();

        switch(choice){
            case  1:
                //存款
                deposit(account);
                break;
            case  2:
                //取款
                withdraw();
                break;
            case  3:
                //查询余额
                queryBalance();
                break;
            case  4:
                //转账
                transfer();
                break;
            case  5:
                //贷款
                requestLoan();
                break;
            case  6:
                //还款
                payLoan();
                break;
            case  7:
                //修改密码
                modifyPassword();
                break;
            case  8:
                //注销：回到系统主菜单
                logout();
                break;
        }
    }
    private void deposit(Account account){
        System.out.println("==============");
        System.out.print("请输入存款的金额：");
        int money = input.nextInt();
        account.deposit(money);
        System.out.println("存款成功");
        showMainMenu();//返回账户主菜单

    }
    private void logout(){
        System.out.println("注销成功");
        Start start = new Start();
        start.showSystemMenu();
    }
    private void withdraw(){
        System.out.println("==============");
        System.out.print("请输入取款的金额：");
        double money = input.nextDouble();
        boolean ret = account.withdraw(money);
        if(ret){
            System.out.println("取款成功");
        }else{
            System.out.println("取款失败");
        }
        showMainMenu();
    }
    private void queryBalance(){
        System.out.println("==============");
        System.out.println("您的余额："+account.getBalance()+"元");
        showMainMenu();
    }
    private void transfer(){
        System.out.println("==============");
        System.out.print("请输入要转入的目标账户号：");
        int id= input.nextInt();
        System.out.print("请输入要转账的金额：");
        double money=input.nextDouble();
        Account destAccount = new Bank().findById(id);

        if(null==destAccount){
            System.out.println("目标账户不存在");
        }else{
            if(account.getBalance()<money){
                System.out.println("账户余额不足，无法转账");
            }else{
                account.setBalance(account.getBalance()-money);
                destAccount.setBalance(destAccount.getBalance()+money);
                System.out.println("转账成功，当前账户余额为:"+account.getBalance());
            }
        }
        showMainMenu();
    }
    private void requestLoan(){
        System.out.println("==============");
        //判断是否为可贷款账户
        if(account instanceof ILoanable){
            System.out.println("请输入贷款金额：");
            double money = input.nextDouble();
            ILoanable loan=(ILoanable)account;
            boolean ret = ((ILoanable) account).requestLoan(money);
            if(ret){
                System.out.println("提示：贷款成功，您当前的贷款总额为："+loan.getLoan());
            }else{
                System.out.println("提示：贷款失败");
            }
            showMainMenu();

        }else{
            System.out.println("提示：该账户非可贷款账户");
        }
        showMainMenu();
    }
    private void payLoan(){
        System.out.println("==============");
        //判断是否为可贷款账户
        if(account instanceof ILoanable){
            System.out.println("请输入还贷款金额：");
            double money = input.nextDouble();
            ILoanable loan=(ILoanable)account;
            boolean ret = ((ILoanable) account).payLoan(money);
            if(ret){
                System.out.println("提示：还贷成功，您当前的贷款总额为："+loan.getLoan());
            }else{
                System.out.println("提示：还贷失败");
            }
            showMainMenu();

        }else{
            System.out.println("提示：该账户非可贷款账户");
        }
        showMainMenu();
    }

    public void modifyPassword(){
        System.out.println("请输入原密码：");
        String oldPassword = input.next();
        //判断原密码对不对
        if(oldPassword.equals(account.getPassword())){
            System.out.println("请输入新密码：");
            String newPassword = input.next();
            System.out.println("请再次输入原密码：");
            String rePassword = input.next();
            if(rePassword.equals(newPassword)){
                account.setPassword(newPassword);
                System.out.println("修改成功,请重新登录");
                new Start().showSystemMenu();
            }else{
                System.out.println("两次输入的密码不一致");
            }
        }else{
            System.out.println("提示：原密码错误！");
        }
        showMainMenu();
    }

}

