package coding_test;

public class Member {
  String name;
  int age;
  String address;

  public Member() {
    this("ss");
    System.out.println("기본생성자");
  }

  public Member(String name) {
    this(name,26);
    System.out.println("name 생성자");
  }

  public Member(String name, int age) {
    this(name,age,"영등포구");
    System.out.println("name ,age 생성자");
  }

  public Member(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
    System.out.println("name,age ,address 기본생성자");
  }

  @Override
  public String toString() {
    return "Member{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }

  public static void main(String[] args) {
    Member member = new Member();
  }

}
