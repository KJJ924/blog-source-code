package dynamicProxyPattern.decoratePattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DecoRateSetTest {


    @Test
    void test(){
        DecoRateSet<String>  countList = new DecoRateSet<>(new HashSet<>());

        countList.add("asd");
        countList.addAll(Arrays.asList("23","asgd","afafafaswe"));

        Assertions.assertThat(countList.getCount()).isEqualTo(4);
    }

}