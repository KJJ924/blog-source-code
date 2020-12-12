package live_study_04;

public class Stack {
    private final int [] stackList;
    private final int stackSize;
    private int stackPointer;

    public Stack(int stackSize) {
        this.stackList = new int[stackSize];
        this.stackPointer = -1;
        this.stackSize = stackSize;
    }

    public void push(int data){
        if(stackSize-1 ==stackPointer){
            System.out.println("더 이상 추가할 수 없음");
        }else {
            stackList[++stackPointer] = data;
        }
    }

    public int pop(){
        if(stackPointer ==-1){
            System.out.println("요소를 먼저 추가해주세요");
            return 0;
        }else {
            int i = stackList[stackPointer];
            stackPointer--;
            return i;
        }
    }
}
