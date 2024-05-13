import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board, copy;
    static int max_safezone=Integer.MIN_VALUE;
    static int n,m;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static Queue<int[]> queue=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                int number=Integer.parseInt(st.nextToken());
                board[i][j]=number;
            }
        }
        DFS(0);
        System.out.println(max_safezone);
    }
    public static void DFS(int wall){
        if(wall==3){
            BFS();
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0){
                    board[i][j]=1;
                    DFS(wall+1);
                    board[i][j]=0; // 해당 경우의 안전 구역 개수를 구하고 나면 다른 경우를 위해서 다시 값을 0으로 돌린다.
                }
            }
        }
    }
    public static void BFS() {
        copy=new int[n][m];
        for(int i=0;i<n;i++){
            copy[i]=board[i].clone();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] virus=queue.poll();
            for(int k=0;k<4;k++){
                int nx=virus[0]+dx[k];
                int ny=virus[1]+dy[k];
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(copy[nx][ny]==0){
                        copy[nx][ny]=2;
                        queue.offer(new int[] {nx,ny});
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j]==0){
                    cnt++;
                }
            }
        }
        max_safezone=Math.max(max_safezone,cnt);
    }
}