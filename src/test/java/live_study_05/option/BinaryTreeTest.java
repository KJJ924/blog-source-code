package live_study_05.option;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    BinaryTree binaryTree;

    @BeforeEach
    void beforeEach(){
        binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(10);
        binaryTree.insert(9);

    }

    @Test
    @DisplayName("객체 추가")
    void insert(){
        //when
        boolean insert_20 = binaryTree.insert(20);
        boolean insert_dup_10 = binaryTree.insert(10);
        //then
        assertThat(insert_20).isTrue();
        assertThat(insert_dup_10).isFalse();
    }

    @Test
    @DisplayName("전위 순회 ,깊이우선탐색(DFS)")
    void preOrderTravers(){
        //when
        List<Integer> preOrderTraverse = binaryTree.Traverse(binaryTree.root, BinaryTree.PRE_ORDER_TRAVERSE);
        //then
        assertThat(preOrderTraverse).isEqualTo(List.of(5, 1, 2, 6, 7, 10, 9));
    }
    @Test
    @DisplayName("너비우선탐색(BFS)")
    void BFS(){
        //when
        List<Integer> preOrderTraverse = binaryTree.BFS(binaryTree.root);
        //then
        assertThat(preOrderTraverse).isEqualTo(List.of(5, 1, 6, 2, 7, 10, 9));
    }
    @Test
    @DisplayName("중위 순회")
    void inOrderTravers(){
        //when
        List<Integer> preOrderTraverse = binaryTree.Traverse(binaryTree.root, BinaryTree.IN_ORDER_TRAVERSE);
        //then
        assertThat(preOrderTraverse).isEqualTo(List.of(1, 2, 5, 6, 7, 9, 10));
    }

    @Test
    @DisplayName("후위 순회")
    void postOrderTravers(){
        //when
        List<Integer> preOrderTraverse = binaryTree.Traverse(binaryTree.root, BinaryTree.POST_ORDER_TRAVERSE);
        //then
        assertThat(preOrderTraverse).isEqualTo(List.of(2, 1, 9, 10, 7, 6, 5));
    }


}