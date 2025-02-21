import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[][] graph;
        boolean[][] visited;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int n;
        int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
            m = maps[0].length;

            visited = new boolean[n][];
            for(int i=0;i<n;i++){
                visited[i] = new boolean[m];
            }

            graph = new int[n][];
            for(int i=0;i<n;i++){
                graph[i] = new int[m];
            }

            BFS(maps);
            return graph[n-1][m-1] == 0 ? -1 : graph[n-1][m-1];
    }
    
    void BFS(int[][] maps){
            Queue<Node> queue = new LinkedList<>();
            Node node = new Node(0,0);
            visited[0][0] = true;
            graph[0][0] = 1;
            queue.add(node);
            while(!queue.isEmpty()){
                Node pollNode = queue.poll();
                int nowX = pollNode.x;
                int nowY = pollNode.y;

                for(int i =0;i<4;i++){
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if(nextX >=0 && nextX < n && nextY >= 0 && nextY < m){
                        if(maps[nextX][nextY]==1 && !visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            graph[nextX][nextY] = graph[nowX][nowY] +1;
                            queue.add(new Node(nextX,nextY));
                        }
                    }
                }
            }
        }
    
    class Node{
        int x;
        int y;
        
        public Node(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
}