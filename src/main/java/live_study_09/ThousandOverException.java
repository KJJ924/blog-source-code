package live_study_09;

public class ThousandOverException extends RuntimeException {
    @Override
    public String getMessage() {
        return "1000을 넘길수 없습니다";
    }

}
