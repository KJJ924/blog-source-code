package live_study_04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {
    @Test
    @DisplayName("요소 추가")
    void stack_add() {
        Stack stack = new Stack(2);
        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    @DisplayName("요소 꺼내기")
    void stack_pop() {
        int i = 1;
        Stack stack = new Stack(2);
        stack.push(10);
        stack.push(i);
        int pop = stack.pop();

        assertThat(pop).isEqualTo(i);
    }
}

