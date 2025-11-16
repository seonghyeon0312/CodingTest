import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int n,m,x;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(dest, weight));
        }
        int[] dist = Dijk(x);

        for(int i=1;i<=n;i++){
            if(i==x) continue;

            dist[i] += Dijk(i)[x];
        }

        int maxValue = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            maxValue = Math.max(maxValue, dist[i]);
        }
        System.out.println(maxValue);
    }

    public static int[] Dijk(int start){
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pQueue.add(new Node(start, 0));
        while(!pQueue.isEmpty()){
            Node current = pQueue.poll();
            if(current.weight > distance[current.start]) continue;

            for(Node next : graph.get(current.start)){
                if(distance[next.start] > distance[current.start] + next.weight){
                    distance[next.start] = distance[current.start] + next.weight;
                    pQueue.add(new Node(next.start, distance[next.start]));
                }
            }
        }
        return distance;
    }

    static class Node implements Comparable<Node> {
        int start;
        int weight;

        public Node(int start, int weight){
            this.start = start;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}
