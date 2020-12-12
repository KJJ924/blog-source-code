package live_study_05;

public class main {
    public static void main(String[] args) {
        Account account = new Account("Account ID","Acccount PW" ,"김재준",9999,"서울어딘가");
        Account account1 = new Account();
        account1.setName("김재준");
        account1.setLocal("서울어딘가");
        account1.setAge(9999);
        account1.setAccountID("id");
        account1.setAccountPW("pw");
    }
}
