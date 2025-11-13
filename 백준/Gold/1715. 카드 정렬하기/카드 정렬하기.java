import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine().trim());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            priorityQueue.add(Integer.parseInt(bf.readLine().trim()));
        }

        int count = 0;
        while(priorityQueue.size() > 1){
            int first = priorityQueue.poll();

            int second = priorityQueue.poll();

            count+=(first+second);

            priorityQueue.add(first+second);
        }
        System.out.println(count);
    }
}
