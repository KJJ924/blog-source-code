package examcode.hashcollision;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dkansk924@naver.com
 * @since 2021/08/16
 */


public class CollisionTestMain {

    public static void main(String[] args) {
        SameOnlyHashCodeObject object = new SameOnlyHashCodeObject("객체1", "ABC");
        SameOnlyHashCodeObject object2 = new SameOnlyHashCodeObject("객체2", "DEF");

        Set<SameOnlyHashCodeObject> sameOnlyHashCodeObjects = new HashSet<>();

        // HashCode 동일해도 equals 가 다르면 객체는 저장된다.

        // 호출순서는 다음과 같다.
        // add() 호출 -> HashCode -> 해당 버킷의 사이즈가 0 이면 그대로 저장
        sameOnlyHashCodeObjects.add(object);

        // add() 호출 -> HashCode -> 현재의 버킷사이즈는 1임으로 equals 호출하여 같은지 확인
        // 만약 없다면 LinkedList 형태로 저장
        sameOnlyHashCodeObjects.add(object2);

        System.out.println("==============");

        // add() 호출 -> HashCode -> 현재의 버킷사이즈는 2임으로 equals 호출하여 같은지 확인
        // LinkedList 형태임으로 모든 노드를 탐색하여 equals 로 확인 O(n)
        // object2 객체는 이미 있음으로 저장되지않음.
        sameOnlyHashCodeObjects.add(object2);

        System.out.println(sameOnlyHashCodeObjects.size());
    }
}
