package live_study_11;

import java.util.EnumSet;

public class MainClient {
    public static void main(String[] args) {
        CARD[] cards = CARD.values();


        CARD samsung1 = Enum.valueOf(CARD.class,"SAMSUNG");
        CARD samsung = CARD.valueOf("SAMSUNG");

        System.out.println(samsung1== samsung);
        Long money =1000L;
        for (CARD card : cards) {
            System.out.printf("%d원을 결제 할때 %s의 적립금은 %d원 \n"
                    ,money,card.getName(),card.payBack(money));
        }


        //=======================================================

        EnumSet<CARD> cards1 = EnumSet.allOf(CARD.class);  //전부 가져오기
        System.out.println(cards1);


        EnumSet<CARD> cards2 = EnumSet.of(CARD.HYUNDAI, CARD.KAKAO); // 선택 가져오기
        System.out.println(cards2);

        EnumSet<CARD> cards3 = EnumSet.complementOf(cards2); //선택한거 제외하고 가져오기
        System.out.println(cards3);

        EnumSet<CARD> cards4 = EnumSet.range(CARD.SAMSUNG, CARD.HYUNDAI); //범위로 가져오기
        System.out.println(cards4);


    }
}
