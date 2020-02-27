package sp20.dis.examprep;

import java.util.Arrays;

/**
 * Worksheet 6, problem 2.
 */
public class MaxPool {
    public static void test() {
        int[][] testImg = {{78, 7, 64, 24}, {26, 12, 53, 94}, {42, 62, 14, 57}, {43, 51, 73, 83}};
        System.out.println(Arrays.deepToString(maxPool(testImg, 2)));
    }

    static int[][] maxPool(int[][] img, int windowSize) {

        int resRows = img.length / windowSize;
        int resCols = img[0].length / windowSize;

        int[][] result = new int[resRows][resCols];

        for (int r = 0; r < img.length; r++) {
            for (int c = 0; c < img[0].length; c++) {
                int largestSoFar = Math.max(result[r / windowSize][c / windowSize],
                        img[r][c]);
                result[r / windowSize][c / windowSize] = largestSoFar;
            }
        }

        return result;
    }
}