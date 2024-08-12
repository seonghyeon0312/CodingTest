import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int[][] board;
    static boolean[][] visit;
    static int n,m;
    static int count=0;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> iceBerg = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        board=new int[n][m];
        visit=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]!=0){
                    iceBerg.offer(new Node(i,j));
                }
            }
        }

        while(true){
            melting();
            count+=1;
            if(iceBerg.isEmpty()){
                count=0;
                break;
            }
            //빙하가 2개로 나뉘어졌는지 확인하는 bfs
            int ice=bfs();
            if(ice!=iceBerg.size()){
                break;
            }
            visit=new boolean[n][m];
            queue.clear();
        }
        System.out.println(count);
    }

    private static void melting(){
        Queue<Integer> tempQueue=new LinkedList<>();

        int size= iceBerg.size();;
        for(int i=0;i< size; i++){
            Node node = iceBerg.poll();
            int cnt=0;
            for(int j =0 ;j<4;j++){
                int nx=node.getX()+dx[j];
                int ny=node.getY()+dy[j];
                if(board[nx][ny]==0){
                    cnt++;
                }
            }
            tempQueue.offer(cnt);
            iceBerg.offer(node);
        }

        for(int i=0;i<size;i++){
            Node node = iceBerg.poll();
            board[node.getX()][node.getY()]-=tempQueue.poll();
            if(board[node.getX()][node.getY()]<=0){
                board[node.getX()][node.getY()]=0;
            }else{
                iceBerg.offer(node);
            }
        }
    }
    private static int bfs(){
        queue.offer(iceBerg.peek());
        int size=0;

        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(visit[node.getX()][node.getY()]){
                continue;
            }
            size++;
            visit[node.getX()][node.getY()]=true;
            for(int i=0;i<4;i++){
                int nx=node.getX()+dx[i];
                int ny=node.getY()+dy[i];
                if(board[nx][ny]!=0){
                    queue.offer(new Node(nx,ny));
                }
            }
        }
        return size;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
}