package live_study_04;

public class CircularQueue {
    private int[] queueList;
    private int pollPointer;
    private int addPointer;
    private int size;

    public CircularQueue(int size) {
        this.queueList = new int[size+1];
        this.size = size+1;
        this.pollPointer = 0;
        this.addPointer = 0;
    }
    public boolean isFull(){
        return (addPointer + 1) % size == pollPointer;
    }
    public void add(int value){
        if(isFull()){
            System.out.println("더 이상 추가 할 수 없음");
        }else {
            addPointer = (++addPointer)%size;
            queueList[addPointer] = value;
        }
    }

    public int poll(){
        if(addPointer==pollPointer){
            System.out.println("요소가 존재하지 않습니다.");
            return 0;
        }
         pollPointer = (++pollPointer) % size;

        return queueList[pollPointer];
    }
}
