import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] graph;
        boolean[] visited;
        int count =0;
        public int solution(int n, int[][] computers){
            int answer =0;
            visited = new boolean[n+1];

            graph = new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(computers[i][j]==1){
                        graph[i+1].add(j+1);
                        graph[j+1].add(i+1);
                    }
                }
            }

            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    BFS(i);
                    count++;
                }
            }
            return count;
        }

        void BFS(int index){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(index);
            while(!queue.isEmpty()){
                Integer poll = queue.poll();
                for (int number : graph[poll]) {
                    if(!visited[number]){
                        visited[number] = true;
                        queue.add(number);
                    }
                }
            }
        }
}