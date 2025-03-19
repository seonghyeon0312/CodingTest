import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import static java.lang.Math.max;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int count=0;
    static int maxHeight = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][];

        for(int i=0;i<N;i++){
            board[i]=Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            OptionalInt maxValue = Arrays.stream(board[i]).max();
            maxHeight = max(maxHeight, maxValue.getAsInt());
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<=maxHeight;i++){
            visited = new boolean[N][N];
            DFS(i,0);
            maxArea = max(maxArea,count);
            count =0;
        }
        System.out.println(maxArea);
    }

    public static void DFS(int height, int depth){
        if(depth==N){
            return;
        }
        for(int col = 0;col<N;col++){
            if(board[depth][col]>height && !visited[depth][col]){
                BFS(height,depth,col);
                count+=1;
            }
        }
        DFS(height,depth+1);
        return;
    }

    public static void BFS(int height,int row, int col){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row,col));
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        while (!queue.isEmpty()){
            Node poll = queue.poll();

            for(int i=0;i<4;i++){
                int newX= poll.x+dx[i];
                int newY= poll.y+dy[i];

                if (newX>=0 && newX<N && newY>=0 && newY<N){
                    if(!visited[newX][newY] && board[newX][newY]>height){
                        visited[newX][newY]=true;
                        queue.add(new Node(newX,newY));
                    }
                }

            }
        }
    }
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}