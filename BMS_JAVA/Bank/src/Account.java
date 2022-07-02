
//账户类：抽象类
public abstract class Account {

    private static long currentID=1000;//记录当前编号

    private long id;
    private String password;
    private String name;
    private String email;
    private String personID;
    private double balance;

    //构造方法

    //无参构造中初始化当前账户初始编号
    public Account() {
        this.id=++currentID;
    }

    /*成员方法*/

    //存款方法deposit(double money)  设置为final:子类不可重写
    public final void deposit(double money){
        this.balance += money;
    }


    //取款方法withdraw(double money)  设置为abstract抽象方法，子类必须根据业务重写
    public abstract boolean withdraw(double money);

    //getter和setter

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPersonID() {
        return personID;
    }
    public void setPersonID(String personID) {
        this.personID = personID;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

}

