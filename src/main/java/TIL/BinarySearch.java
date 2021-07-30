package TIL;

/**
 * @author dkansk924@naver.com
 * @since 2021/07/30
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] intArray = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            intArray[i] = i * 2;
        }

        long targetValue = 123456879;

        int startIndex = 0;
        int lastIndex = intArray.length;
        int halfLength = (startIndex + lastIndex) / 2;

        int count = 0;
        while (!(intArray[halfLength] == targetValue)) {
            int curValue = intArray[halfLength];
            if (curValue < targetValue) {
                startIndex = halfLength;
            } else {
                lastIndex = halfLength;
            }
            halfLength = (startIndex + lastIndex) / 2;
            if (startIndex == halfLength) {
                System.out.println("없음");
                break;
            }
            count++;
        }
        System.out.println(count);
    }

}
