package live_study_04;

public class Queue {
    private int[] queueList;
    private int pollPointer;
    private int addPointer;
    private int size;

    public Queue(int size) {
        this.queueList = new int[size];
        this.size = size;
        this.pollPointer=0;
        this.addPointer = -1;
    }

    public void add(int value){
        if(addPointer == size-1){
            System.out.println("더 이상 추가 할 수 없음");
        }else {
            queueList[++addPointer] = value;
        }
    }

    public int poll(){
        if(addPointer==-1){
            System.out.println("요소가 존재하지 않습니다.");
            return 0;
        }
        addPointer--;
        int result = queueList[pollPointer];

        // 요소를 꺼내고 앞으로 정렬하는 작업
        // 요소가 많아지면 효율이 떨어짐
        for (int i = 0; i < queueList.length-1; i++) {
            queueList[i] = queueList[i+1];
        }
        return result;
    }
}
