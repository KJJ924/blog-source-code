package live_study_11;

import java.util.function.Function;

public enum CARD {
    SAMSUNG("삼성카드",money->(money/100)),
    KAKAO("카카오카드",money->(money*2/100)),
    HYUNDAI("현대카드",money->(money*3/100));

    private final String name;
    private final Function<Long,Long> point;

    private CARD(String name,Function<Long,Long> point) {
        this.name = name;
        this.point=point;
    }

    public String getName() {
        return name;
    }
    public Long payBack(Long money){
       return point.apply(money);
    }
}
