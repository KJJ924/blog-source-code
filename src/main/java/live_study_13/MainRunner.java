package live_study_13;

import java.io.*;

public class MainRunner {

    public static void main(String[] args) {

        //파일 출력
        File testFile = new File("/Users/kimjajan/IdeaProjects/blog-source-code/src/main/java/live_study_13/test.txt");
        try(FileReader fr = new FileReader(testFile);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //파일 쓰기
        String path = "/Users/kimjajan/IdeaProjects/blog-source-code/src/main/java/live_study_13/newFile.txt";
        File newFile = new File(path);
        try(FileWriter wr = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(wr)) {
            for (int i = 0; i < 30; i++) {
                bw.write("Hello" +i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
