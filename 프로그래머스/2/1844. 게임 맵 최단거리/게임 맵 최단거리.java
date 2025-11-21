import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps){
        Queue<Cord> queue = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        maps[n-1][m-1] = -1;
        boolean[][] visited = new boolean[n][m];
        queue.add(new Cord(0,0));
        visited[0][0] = true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        while(!queue.isEmpty()){
            Cord now = queue.poll();
            if(now.x == n-1 && now.y == m-1) break;
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && maps[nx][ny] != 0){
                        queue.add(new Cord(nx,ny));
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[now.x][now.y]+1;
                    }
                }
            }
        }
        return maps[n-1][m-1];
    }
    
    class Cord{
        int x;
        int y;
        
        public Cord(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}