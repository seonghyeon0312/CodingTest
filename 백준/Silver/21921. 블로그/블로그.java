import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()); // 두 번째 줄: N개가 한 줄에 들어옴
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        // 초기 윈도우
        int sum = 0;
        for (int i = 0; i < x; i++) sum += a[i];
        int max = sum;
        int cnt = (max == 0 ? 0 : 1);

        // 슬라이딩
        for (int i = x; i < n; i++) {
            sum += a[i] - a[i - x];
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                if (max != 0) cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}