import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int num=2;
    static int n;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static ArrayList<Integer> apt=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        map=new int[n][n];
        visited=new boolean[n][n];
        int cnt=0;
        for(int i=0;i<n;i++){
            String[] temp=sc.next().split("");
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(temp[j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    apt.add(BFS(i,j));
                    cnt++;
                    num+=1;
                }
            }
        }

        Collections.sort(apt);
        System.out.println(cnt);
        for(int i=0;i<apt.size();i++){
            System.out.println(apt.get(i));
        }
    }

    private static int BFS(int i, int j) {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j]=true;
        int result=1;
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            for(int k=0;k<4;k++){
                int x=now[0]+dx[k];
                int y=now[1]+dy[k];
                if(x>=0&&x<n&&y>=0&&y<n){
                    if(!visited[x][y]){
                        visited[x][y]=true;
                        if(map[x][y]!=0){
                            map[x][y]=num;
                            result++;
                            queue.add(new int[] {x,y});
                        }
                    }
                }
            }
        }
        return result;
    }
}