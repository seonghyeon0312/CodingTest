import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

    static int N;
    static int[][] board;
    static int[][] result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][];
        result = new int[N][];
        visited = new boolean[N][];


        for(int i=0;i<N;i++){
            board[i] = new int[N];
            result[i] = new int[N];
            visited[i] = new boolean[N];
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                result[i][j] = 3000;
            }
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            int[] tmp = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++){
                board[i][j] = (tmp[j]+1)%2;
            }
        }
        
        // white -> 0, black -> 1
        BFS();
        System.out.println(result[N-1][N-1]);
    }

    static void BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        result[0][0] = board[0][0];
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx= node.x+dx[i];
                int ny= node.y+dy[i];

                if(nx>=0 && nx<N && ny<N && ny>=0){
                    if(result[nx][ny] > board[nx][ny]+result[node.x][node.y]){
                        result[nx][ny] = board[nx][ny] + result[node.x][node.y];
                        queue.add(new Node(nx,ny));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        Node(int a, int b){
            this.x=a;
            this.y=b;
        }
    }
}