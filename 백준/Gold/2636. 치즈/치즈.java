import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Air{
        int x;
        int y;
        public Air(int i,int j){
            this.x=i;
            this.y=j;
        }
    }
    static Queue<Air> air_que;
    static int[][] board;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board =new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int result=0;
        int cnt=0;
        visited=new boolean[n][m];
        while(check()){
            result=Air_Bfs();
            cnt++;
        }
        System.out.println(cnt);
        System.out.print(result);
    }
    public static boolean check(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1&&!visited[i][j]) return true;
            }
        }
        return false;
    }
    public static int Air_Bfs(){
        visited=new boolean[n][m];
        int cnt=0;
        air_que=new LinkedList<>();
        air_que.add(new Air(0,0));
        while(!air_que.isEmpty()){
            Air air=air_que.poll();
            visited[air.x][air.y]=true;
            for(int i=0;i<4;i++){
                int nx=air.x+dx[i];
                int ny=air.y+dy[i];
                if(nx<n&&ny<m&&ny>=0&&nx>=0){
                    if(!visited[nx][ny]&&board[nx][ny]==0){
                        visited[nx][ny]=true;
                        air_que.add(new Air(nx,ny));
                    }else if(!visited[nx][ny]&&board[nx][ny]==1){
                        visited[nx][ny]=true;
                        board[nx][ny]=0;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
