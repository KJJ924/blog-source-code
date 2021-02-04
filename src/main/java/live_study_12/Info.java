package live_study_12;

import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) //런타임시까지 해당 애노테이션을 유지하고있어야한다!
public @interface Info {
    String value();
}
