import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        int[][] board = new int[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] start = {0,0};
        queue.add(start);
        board[0][0] = 1;
        board[n-1][m-1]= -1;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cord = queue.poll();
            
            for(int i=0;i<4;i++){
                int nx = cord[0]+dx[i];
                int ny = cord[1]+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && maps[nx][ny] ==1){
                    board[nx][ny] = board[cord[0]][cord[1]]+1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        
        return board[n-1][m-1];
    }
}