import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static class Dust{
        int x;
        int y;
        int scale;
        public Dust(int i,int j,int w){
            this.x=i;
            this.y=j;
            this.scale=w;
        }
    }
    static int r;
    static int c;
    static int t;
    static int down;
    static int[][] board;
    static int dust=0;
    static Queue<Dust> queue=new LinkedList<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        t=sc.nextInt();
        board=new int[r][c];// 확산 후
        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j]==-1){
                    down=i;
                }
            }
        }

        for(int i=0;i<t;i++){
            check();
            spread();
            moving();
        }
        int sum_dust=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum_dust+=board[i][j];
            }
        }
        System.out.println(sum_dust+2);
    }
    public static void check(){
        queue=new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]!=-1&&board[i][j]!=0){
                    queue.add(new Dust(i,j,board[i][j]));
                }
            }
        }
    }
    public static void spread(){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        while(!queue.isEmpty()){
            Dust dust=queue.poll();
            if(dust.scale<5) continue;
            int nw=dust.scale/5;
            int cnt=0;
            for(int i=0;i<4;i++){
                int nx=dust.x+dx[i];
                int ny=dust.y+dy[i];
                if(nx<r&&ny<c&&nx>=0&&ny>=0&&board[nx][ny]!=-1){
                    board[nx][ny]+=nw;
                    board[dust.x][dust.y]-=nw;
                }
            }
        }

    }
    public static void moving(){
        int clean=down-1;
        int clean_down=down;
        for(int i=clean-1;i>0;i--){
            board[i][0]=board[i-1][0];
        }
        for(int i=0;i<c-1;i++){
            board[0][i]=board[0][i+1];
        }
        for(int i=0;i<clean;i++){
            board[i][c-1]=board[i+1][c-1];
        }
        for(int i=c-1;i>1;i--){
            board[clean][i]=board[clean][i-1];
        }
        board[clean][1]=0;
        for(int i=clean_down+1;i<r-1;i++){
            board[i][0]=board[i+1][0];
        }
        for(int i=0;i<c-1;i++){
            board[r-1][i]=board[r-1][i+1];
        }
        for(int i=r-1;i>clean_down;i--){
            board[i][c-1]=board[i-1][c-1];
        }
        for(int i=c-1;i>1;i--){
            board[clean_down][i]=board[clean_down][i-1];
        }
        board[clean_down][1]=0;
    }
}
