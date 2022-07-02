
import java.util.Scanner;

//银行管理系统：启动类
public class Start {

    private Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("******欢迎使用银行管理系统******");

        new Start().showSystemMenu();



    }
    //显示系统主菜单
    public void showSystemMenu(){

        System.out.println("==============");
        System.out.println("1.开户\t\t2.登录");
        System.out.println("==============");
        System.out.print("请选择：");
        int choice = input.nextInt();

        switch(choice){
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("输入有误！");
        }
    }
    //实现注册方法
    private void register(){

        System.out.println("请选择要办理的账户种类：(1.储蓄账户 2.信用账户 3.可贷款的储蓄账户 4.可贷款的信用账户)");
        System.out.print("请选择：");
        int choice = input.nextInt();

        Account account=null;

        switch(choice){
            case 1:
                account=new SavingAccount();
                break;
            case 2:
                account=new CreditAccount();
                break;
            case 3:
                account=new LoanSavingAccount();
                break;
            case 4:
                account=new LoanCreditAccount();
                break;
        }

        fillInformation(account);

        Bank bank = new Bank();
        boolean flag = Bank.register(account);
        if(true==flag){
            System.out.println("开户成功,账户号为:"+account.getId());
        }else{
            System.out.println("开户失败！");
        }
        showSystemMenu();
    }
    //注册中的填写基本信息方法
    private void fillInformation(Account account){

        System.out.print("请输入姓名：");
        String name = input.next();
        account.setName(name);

        while(true){
            System.out.print("请输入密码：");
            String password = input.next();
            System.out.print("请再次输入密码：");
            String passwordAgain = input.next();

            if(passwordAgain.equals(password)){
                account.setPassword(password);
                break;
            }else{
                System.out.println("两次输入的密码不一致，请重新输入");
            }
        }

        System.out.print("请输入个人身份证号：");
        String personID = input.next();
        account.setPersonID(personID);

        System.out.print("请输入个人邮箱：");
        String email = input.next();
        account.setEmail(email);

        //判断是否为信用账户，要多输入一次申请的透支额度
        if(account instanceof CreditAccount){

            System.out.print("请输入申请的透支额度：");
            Double  ceiling= input.nextDouble();
            ((CreditAccount) account).setCeiling(ceiling);

        }
    }

    //实现登录方法
    private void login(){

        System.out.print("请输入账户号：");
        long id = input.nextLong();
        System.out.print("请输入密码：");
        String password = input.next();

        Account account = Bank.login(id, password);

        if(account!=null){
            System.out.println("==============");
            System.out.println("欢迎您："+account.getName());
            AcccountMenu acccountMenu = new AcccountMenu(account);
            acccountMenu.showMainMenu();//显示账户主菜单

        }else{
            System.out.println("提示：账户号或密码错误！");
            showSystemMenu();//返回系统主菜单
        }
    }
}

