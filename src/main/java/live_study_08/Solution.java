package live_study_08;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        JaeJoon jaeJoon = new JaeJoon(25);
        jaeJoon.programing();
        Kevin kevin = new Kevin(25);
        Fish fish = new Fish();

//=======================사람 그룹========================
        List<Person> people = new ArrayList<>();
        people.add(jaeJoon);
        people.add(kevin);
        for (Person person : people) {
            person.language();
            person.walk();
            person.eat();
        }

//=========================헤엄 칠수 있는 그룹==========================
        List<SwimAble> swimAbles = new ArrayList<>();
        swimAbles.add(fish);
        swimAbles.add(jaeJoon);

        for (SwimAble swimAble : swimAbles) {
            swimAble.swim();
        }
    }
}
