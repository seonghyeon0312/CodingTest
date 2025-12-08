import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> mooLen = new ArrayList<>();

        mooLen.add(3);
        int k = 1;
        while(true){
            if(mooLen.get(k-1) >= n) break;
            int lastLen = mooLen.get(k-1);
            mooLen.add(lastLen * 2 + k++ + 3);
        }
        dfs(n, k, mooLen);
    }

    public static void dfs(int targetIdx, int k, List<Integer> moo ){
        if (k == 0) {
            if (targetIdx == 1) System.out.println("m");
            else System.out.println("o");
            return;
        }

        int left = moo.get(k - 1);
        int mid = k + 3;

        if (targetIdx <= left) {
            dfs(targetIdx, k - 1, moo);
        } else if (targetIdx <= left + mid) {
            if (targetIdx - left == 1) System.out.println("m");
            else System.out.println("o");
        } else {
            dfs(targetIdx - left - mid, k - 1, moo);
        }
    }
}
