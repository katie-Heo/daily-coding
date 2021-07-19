package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 틀린 문제가 간간히 있었음.
 * 문제 : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * 풀이 : https://jobjava00.github.io/algorithm/codility/lesson2/CyclicRotation/
 */
public class Lesson2 {
    public int[] solutionMy(int[] A, int K) {
        // write your code in Java SE 8

        int first = A[0];
        boolean allSame = Arrays.stream(A).allMatch(a -> first == a);
        if (allSame) {
            return A;
        }

        if (A.length == K) {
            return A;
        }

        int startIndex = A.length - K;
        int [] back = Arrays.copyOfRange(A, startIndex, A.length);
        int [] front = Arrays.copyOfRange(A, 0, startIndex);
        int [] result = new int [A.length];
        System.arraycopy(back, 0, result, 0, back.length);
        System.arraycopy(front, 0, result, back.length, front.length);
        return result;
    }
    // 정답
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int index = (K + i) % length;
            result[index] = A[i];
        }
        return result;
    }

}
