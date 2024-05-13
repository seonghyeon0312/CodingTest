import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int zero_cnt=0;
    static int[][] map;
    static int[][] date;
    static int n,m;
    static Queue<int[]> queue=new LinkedList<>();
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        date=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                int number=Integer.parseInt(st.nextToken());
                if(number==0) zero_cnt++;
                if(number==1){
                    queue.offer(new int[] {i,j});
                }
                map[i][j]=number;
            }
        }
        if(zero_cnt==0){
            System.out.println(0);
            return;
        }
        BFS();
        boolean all=true;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    all=false;
                }
            }
        }
        if(all){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    result=Math.max(result, date[i][j]);
                }
            }
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }
    public static void BFS(){
        while(!queue.isEmpty()){
            int[] tomato=queue.poll();
            for(int i=0;i<4;i++){
                int nx=tomato[0]+dx[i];
                int ny=tomato[1]+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==0){
                    queue.offer(new int[] {nx,ny});
                    map[nx][ny]=1;
                    date[nx][ny]=date[tomato[0]][tomato[1]]+1;
                }
            }
        }
    }
}