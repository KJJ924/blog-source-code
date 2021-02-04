package live_study_12;

import java.lang.reflect.Field;
import java.util.Arrays;

public class InstanceService {
    @Deprecated
    static  <T> T getObject(Class<T>tClass){
        T t = newInstance(tClass); // class 의 인스턴스를 생성

        //클래스의 필드를 모두가져옴
        Arrays.stream(tClass.getDeclaredFields()).forEach(f->{
            f.setAccessible(true); // 접근 허용
            Info annotation = f.getAnnotation(Info.class); //필드 에 붙어있는 애노테이션가져오기
            try {
                f.set(t,annotation.value()); //애노테이션 값을 해당 필드에 바인딩
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return t; // 인스턴스 반환
    }

    private static <T> T newInstance(Class<T> tClass) {
        try {
           return tClass.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
