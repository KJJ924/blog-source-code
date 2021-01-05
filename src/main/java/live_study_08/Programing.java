package live_study_08;

public interface Programing {
    void programing();

    default void application(){
        debug();
        System.out.println("애플리케이션을 만듭니다.");
    }

    private void debug(){
        System.out.println("디버깅을합니다.");
    }
}
