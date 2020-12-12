package live_study_05;

public class Account {
    private String AccountID;
    private String AccountPW;
    private String name;
    private int age;
    private String local;

    public Account() {
        System.out.println("기본생성자 입니다");
    }

    public Account(String accountID, String accountPW, String name, int age, String local) {
        AccountID = accountID;
        AccountPW = accountPW;
        this.name = name;
        this.age = age;
        this.local = local;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public void setAccountPW(String accountPW) {
        AccountPW = accountPW;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
