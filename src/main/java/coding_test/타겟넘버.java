package coding_test;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }
    public int DFS(int[] numbers, int target, int index, int num) {

        if(index == numbers.length){
            return num == target ? 1 : 0;
        }else {
            return DFS(numbers,target,index+1,num+numbers[index])+
                DFS(numbers,target,index+1, num-numbers[index]);
        }
    }

    public static void main(String[] args) {
        타겟넘버  subject = new 타겟넘버();
        int solution = subject.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(solution);
    }
}
