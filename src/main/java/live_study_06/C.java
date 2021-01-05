package live_study_06;

import java.util.Objects;

public class C {
    final String message = "C 클래스";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return Objects.equals(message, c.message);
    }
    
}
