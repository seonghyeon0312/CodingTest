import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static PriorityQueue<Node> pQ=new PriorityQueue<>();
    static Integer min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());

        int start, end;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            start=Integer.parseInt(st.nextToken());
            end=Integer.parseInt(st.nextToken());
            if(start<min){
                min=start;
            }
            if(end>max){
                max=end;
            }
            pQ.offer(new Node(start,end));
        }

        greedy();
        System.out.println(count);
    }

    private static void greedy() {
        int end=-1;
        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            int s=node.mStart;
            int e=node.mEnd;
            if(s>=end){
                end=e;
                count++;
            }

        }
    }

    private static class Node implements Comparable<Node> {
        int mStart;
        int mEnd;
        int duration;

        public Node(int mStart, int mEnd) {
            this.mStart = mStart;
            this.mEnd = mEnd;
            this.duration = mEnd - mStart;
        }

        @Override
        public int compareTo(Node node) {
            // mEnd 기준으로 오름차순 정렬
            if (this.mEnd != node.mEnd) {
                return Integer.compare(this.mEnd, node.mEnd);
            }
            // mEnd 같다면 mStart를 기준으로 오름차순 정렬
            return Integer.compare(this.mStart, node.mStart);
        }
    }
}