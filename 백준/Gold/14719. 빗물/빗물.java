import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] h = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) h[i] = Integer.parseInt(st.nextToken());

        // Core optimization: precompute left/right max heights per column
        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        int max = 0;
        for (int i = 0; i < W; i++) {
            max = Math.max(max, h[i]);
            leftMax[i] = max;
        }
        max = 0;
        for (int i = W - 1; i >= 0; i--) {
            max = Math.max(max, h[i]);
            rightMax[i] = max;
        }

        long water = 0L; // use long just in case
        for (int i = 0; i < W; i++) {
            int bound = Math.min(leftMax[i], rightMax[i]);
            if (bound > h[i]) water += bound - h[i];
        }

        System.out.println(water);
    }
}
