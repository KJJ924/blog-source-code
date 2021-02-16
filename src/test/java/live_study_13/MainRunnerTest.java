package live_study_13;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static org.junit.jupiter.api.Assertions.*;

class MainRunnerTest {

    @Test
    void byteStream(){
        System.out.write('a'); // 바이트코드 3
        System.out.write('1'); // 바이트코드 3
        System.out.flush(); // 출력
    }

    @Test
    void InputStreamReader() throws IOException {
        OutputStreamWriter rd = new OutputStreamWriter(System.out);
        rd.write("Hello");
        rd.flush();
    }

}