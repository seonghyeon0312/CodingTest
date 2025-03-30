import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][][] board;
    static int M,N,H;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] dh = {1,-1};
    static int result = 0;
    static int count=0;
    static boolean[][][] visited;
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        board = new int[H][N][M];
        visited = new boolean[H][N][M];


        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    board[i][j][k] = sc.nextInt();
                    if(board[i][j][k] == 1){
                        queue.offer(new Node(i,j,k));
                    }else if(board[i][j][k] == 0){
                        count++;
                    }
                }
            }
        }
        BFS();

        if(count==0){
            System.out.println(result-1);
        }else{
            System.out.println(-1);
        }
    }

    static void BFS(){
        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 하루에 익힐 토마토 개수
            for (int j = 0; j < size; j++) {
                Node node = queue.poll();

                // 4방향
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[node.h][ny][nx]) {
                        if (board[node.h][ny][nx] == 0) {
                            board[node.h][ny][nx] = 1;
                            count--;
                            visited[node.h][ny][nx] = true;
                            queue.offer(new Node(node.h, ny, nx));
                        }
                    }
                }

                // 위아래 층
                for (int i = 0; i < 2; i++) {
                    int nh = node.h + dh[i];
                    if (nh >= 0 && nh < H && !visited[nh][node.y][node.x]) {
                        if (board[nh][node.y][node.x] == 0) {
                            board[nh][node.y][node.x] = 1;
                            count--;
                            visited[nh][node.y][node.x] = true;
                            queue.offer(new Node(nh, node.y, node.x));
                        }
                    }
                }
            }

            // 하루가 지났으므로 증가
            result++;
        }
    }

    static class Node{
        int x;
        int y;
        int h;
        Node(int a, int b,int c){
            this.h=a;
            this.x=c;
            this.y=b;
        }


    }
}