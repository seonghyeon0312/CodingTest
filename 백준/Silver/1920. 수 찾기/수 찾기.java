import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력 전용 스캐너 (BufferedInputStream 기반)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sgn = 1, x = 0;
            // skip non-number
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sgn;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder(1 << 20); // 출력 버퍼

        int N = fs.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = fs.nextInt();
        Arrays.sort(arr); // 제자리 정렬 (추가 메모리 X)

        int M = fs.nextInt();
        for (int i = 0; i < M; i++) {
            int target = fs.nextInt();
            out.append(binarySearch(arr, target) ? '1' : '0').append('\n');
        }
        System.out.print(out);
    }

    // 반복문 기반 이진 탐색 (start > end 처리 포함)
    static boolean binarySearch(int[] a, int target) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int m = a[mid];
            if (m == target) return true;
            if (m < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
// 메모리 초과 방지:
// - Integer 박싱 제거, 기본형 int 배열 사용으로 메모리 절약
// - 배열을 하나만 사용하고 제자리 정렬하여 추가 메모리 사용 최소화
// - 재귀 대신 반복문 이진 탐색으로 스택 오버플로우 방지
// - BufferedInputStream 기반 빠른 입출력으로 시간 단축