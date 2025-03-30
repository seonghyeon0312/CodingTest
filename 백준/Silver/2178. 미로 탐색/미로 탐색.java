import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st= new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        graph=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String line=st.nextToken();
            for(int j=0;j<m;j++){
                graph[i][j]=Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.print(graph[n-1][m-1]);
    }
    private static void BFS(int start,int end){
        Queue<int[]> queue=new LinkedList<>();
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        visited[start][end]=true;
        //2차원이므로 배열 형태로 큐에 넣어야 한다.
        queue.offer(new int[]{start,end});
        while (!queue.isEmpty()){
            int[] find=queue.poll();
            for(int i=0;i<4;i++){
                int nx=find[0]+dx[i];
                int ny=find[1]+dy[i];

                if(nx>=0&&ny>=0 && nx<n&&ny<m){
                    if(graph[nx][ny]!=0 && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        graph[nx][ny]=graph[find[0]][find[1]]+1;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
