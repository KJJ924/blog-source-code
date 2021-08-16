package examcode.hashcollision;

/**
 * @author dkansk924@naver.com
 * @since 2021/08/16
 */


public class SameOnlyHashCodeObject {

    private final String name;
    private final String message;

    public SameOnlyHashCodeObject(String name, String message) {
        this.name = name;
        this.message = message;
    }


    @Override
    public int hashCode() {
        System.out.println("callHashCode");
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("callEquals");
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "SameOnlyHashCodeObject{" +
            "name='" + name + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
