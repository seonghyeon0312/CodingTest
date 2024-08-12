import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] board;
    static boolean[] visit =new boolean[26];
    static int maxLen=1;

    static int R,C;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        board=new int[R][C];
        

        for(int i=0;i<R;i++){
            st=new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            for(int j=0;j<C;j++){
                board[i][j]= temp.charAt(j) - 'A';
            }
        }
        dfs(0,0,0);
        System.out.println(maxLen);
    }

    private static void dfs(int x, int y,int cnt){
        if(visit[board[x][y]]){
            maxLen=Math.max(maxLen,cnt);
            return;
        }
        int count=0;

        //alphabet 방문여부
        
        visit[board[x][y]]=true;

        while(count<4){
            int newX=x+dx[count];
            int newY=y+dy[count];

            if(newX>=0 && newX<R && newY>=0 && newY<C){
                dfs(newX,newY,cnt+1);
            }
            count++;
        }
        visit[board[x][y]]=false;
    }
}