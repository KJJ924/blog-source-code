package coding_test;
import java.util.*;
import java.util.stream.Collectors;
public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (String s : phone_book) {
            List<String> list = Arrays.stream(phone_book).filter(s1 -> !s1.equals(s)).collect(Collectors.toList());
            for (String s1 : list) {
                if(s1.startsWith(s)){
                    return false;
                }
            }
        }
        return answer;
    }
}
