import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        while(t-- > 0){
            int k = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            PriorityQueue<Long> pQueue = new PriorityQueue<>();

            while(k-- > 0){
                pQueue.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while(pQueue.size() > 1){
                Long num1 = pQueue.poll();
                Long num2 = pQueue.poll();

                result += (num1+num2);
                pQueue.add(num1+num2);
            }

            System.out.println(result);
        }
    }
}
