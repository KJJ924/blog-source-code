package coding_test;

public class 서울에서김서방찾기 {
    public static String solution(String[] seoul) {
        int index= 0;
        for(int i = 0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                index = i;
            }
        }
        return "김서방은 "+index+"에 있다";
    }

    public static void main(String[] args) {
        solution(new String[]{"Jane", "Kim"});
    }
}
