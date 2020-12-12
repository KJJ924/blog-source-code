package live_study_04.option1;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Member {
    private String id;
    private Map<String ,Boolean> weekJoinMap = new LinkedHashMap<>();
    private Double percent;
    public Member(String id) {
        this.id = id;
    }

    public void percentProcess(){
        double count = 0;
        Collection<Boolean> values = weekJoinMap.values();
        for (Boolean value : values) {
            if(value){
                count++;
            }
        }
        this.percent = count/18;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Boolean> getWeekJoinMap() {
        return weekJoinMap;
    }

    public void setWeekJoinMap(Map<String, Boolean> weekJoinMap) {
        this.weekJoinMap = weekJoinMap;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

}
