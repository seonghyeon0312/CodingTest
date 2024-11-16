import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    private static String[][] board;
    private static Set<String> resultSet;
    private static String result;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T= Integer.parseInt(st.nextToken());

        for(int i=1;i<=T;i++){

            board= new String[4][];
            resultSet = new HashSet<>();

            for(int j=0;j<4;j++){
                board[j] = new String[4];

                st = new StringTokenizer(bf.readLine());
                for(int k=0;k<4;k++){
                    board[j][k]=st.nextToken();
                }
            }

            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    dfs(j,k,board[j][k]);
                }
            }

            System.out.println("#"+i+" "+resultSet.size());
        }
    }

    private static void dfs(int j,int k, String tempResult){

        if(tempResult.length() == 7){
            resultSet.add(tempResult);
            return;
        }

        for(int i=0;i<4;i++){
            int nx = j+dx[i];
            int ny = k+dy[i];

            if(nx>=0 && ny>=0 && nx<4 && ny<4){
                dfs(nx,ny,tempResult.concat(board[nx][ny]));
            }
        }
    }
}