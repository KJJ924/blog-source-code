package live_study_04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {
    LinkedList linkedList;

    @BeforeEach
    void beforeEach(){
        linkedList = new LinkedList();
    }

    @Test
    @DisplayName("요소 last 인덱스에 추가")
    void add_success() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        LinkedList.Node node = linkedList.add(1);
        Field field = node.getClass().getDeclaredField("data");
        field.setAccessible(true);
        int data = field.getInt(node);

        Method nodeMethod = LinkedList.class.getDeclaredMethod("node", int.class);
        nodeMethod.setAccessible(true);
        LinkedList.Node node1 = (LinkedList.Node) nodeMethod.invoke(linkedList, 0);
        Field field2 = node1.getClass().getDeclaredField("data");
        field2.setAccessible(true);
        int data2 = field2.getInt(node);

        assertThat(linkedList.size()).isEqualTo(1);
        assertThat(data).isEqualTo(data2);
    }

    @Test
    @DisplayName("요소 특정 위치 인덱스에 추가")
    void add_position_success() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        linkedList.add(2);

        LinkedList.Node node = linkedList.add(1,0);
        Field field = node.getClass().getDeclaredField("data");
        field.setAccessible(true);
        int data = field.getInt(node);

        Method nodeMethod = LinkedList.class.getDeclaredMethod("node", int.class);
        nodeMethod.setAccessible(true);
        LinkedList.Node node1 = (LinkedList.Node) nodeMethod.invoke(linkedList, 0);
        Field field2 = node1.getClass().getDeclaredField("data");
        field2.setAccessible(true);
        int data2 = field2.getInt(node);

        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(data).isEqualTo(data2);
    }

    @Test
    @DisplayName("요소 삭제")
    void remove_success() {
        linkedList.add(2);

        linkedList.remove(0);
        int size = linkedList.size();

        assertThat(size).isEqualTo(0);
    }

    @Test
    @DisplayName("요소 존재하는지 확인")
    void contain_Node(){
        LinkedList.Node add = linkedList.add(1);
        boolean contains = linkedList.contains(add);
        assertThat(contains).isTrue();
    }

}