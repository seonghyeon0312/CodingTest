import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0;i<testCase;i++){
            Queue<File> queue = new LinkedList<>();
            PriorityQueue<File> pQueue = new PriorityQueue<>((o1, o2) -> o2.priority - o1.priority);
            int n = sc.nextInt();
            int m = sc.nextInt();

            for(int j=0;j<n;j++){
                File file = new File(j, sc.nextInt(), j==m);

                queue.add(file);
                pQueue.add(file);
            }
            int result =1;
            while(!queue.isEmpty()){
                File polledFile = queue.poll();

                if(polledFile.priority < pQueue.peek().priority){
                    queue.add(polledFile);
                    continue;
                }

                if(polledFile.target){
                    break;
                }
                pQueue.poll();
                result++;
            }

            System.out.println(result);
        }
    }

    private static class File{
        int idx;
        int priority;
        boolean target = false;

        public File(int index, int pri, boolean isTarget){
            idx = index;
            priority = pri;
            target = isTarget;
        }


    }
}


