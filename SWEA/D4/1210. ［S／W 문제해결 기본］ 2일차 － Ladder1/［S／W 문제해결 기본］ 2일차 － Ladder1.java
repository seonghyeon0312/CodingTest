import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int[][] gameBoard;
    private static int[] dx = {0,0,-1};
    private static int[] dy = {1,-1,0};
    private static Now now;


    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<10;i++){
            st=new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            gameBoard = new int[100][];
            for(int j=0;j<100;j++){
                st=new StringTokenizer(bf.readLine());
                gameBoard[j]= new int[100];
                for(int k=0;k<100;k++){
                    gameBoard[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=0;j<100;j++){
                for(int k=0;k<100;k++){
                    if(gameBoard[j][k]==2){
                        now = new Now(j,k,Direction.UP);
                    }
                }
            }

            reverseGameStart();
            System.out.println("#"+N+" "+now.y);
        }
    }
    private static void reverseGameStart(){
        while(now.x!=0){
            if(now.getDirection().getIndex() == 2){
                checkLeftRightAvailable();
            }else{
                checkUpAvailable();
            }

            now.x=now.x+dx[now.getDirection().getIndex()];
            now.y=now.y+dy[now.getDirection().getIndex()];

        }
    }

    private static void checkUpAvailable(){
        int nx=now.x+dx[2];
        int ny=now.y+dy[2];

        if(nx>=0 && ny>=0 && nx<100 && ny<100 && gameBoard[nx][ny]==1){
            now.setDirection(2);
        }
    }

    private static void checkLeftRightAvailable() {
        for(int i=0;i<2;i++){

            int nx=now.x+dx[i];
            int ny=now.y+dy[i];

            if(nx>=0 && ny>=0 && nx<100 && ny<100 && gameBoard[nx][ny]==1){
                now.setDirection(i);
            }
        }
    }

    static class Now{
        int x;
        int y;
        Direction direction;

        public Now(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = Direction.findByIndex(direction);
        }
    }
    static enum Direction{
        RIGHT(0),
        LEFT(1),
        UP(2);

        private final int index;

        public int getIndex(){
            return this.index;
        }
        public static Direction findByIndex(int x) {
            for (Direction dir : Direction.values()) {
                if (dir.getIndex() == x) {
                    return dir;
                }
            }
            throw new IllegalArgumentException("Invalid index: " + x);
        }

        Direction(int index) {
            this.index = index;
        }
    }
}
