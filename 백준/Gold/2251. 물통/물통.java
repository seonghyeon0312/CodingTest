import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] send={0,0,1,1,2,2};
    static int[] receiver={1,2,0,2,0,1};
    static boolean[] result;
    static boolean[][] visited;
    static int[] now=new int[3];

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        now[0]=Integer.parseInt(st.nextToken());
        now[1]=Integer.parseInt(st.nextToken());
        now[2]=Integer.parseInt(st.nextToken());

        visited=new boolean[201][201];
        result=new boolean[201];
        BFS();
        for(int i=0;i<result.length;i++){
            if(result[i]) System.out.print(i+" ");
        }
    }
    private static void BFS(){
        Queue<AB> queue=new LinkedList<>();
        queue.add(new AB(0,0));
        visited[0][0]=true;
        result[now[2]]=true;
        while(!queue.isEmpty()){
            AB p=queue.poll();
            int A=p.A;
            int B=p.B;
            int C=now[2]-A-B;
            for(int k=0;k<6;k++){
                int[] next={A,B,C};
                next[receiver[k]]+=next[send[k]];
                next[send[k]]=0;
                if(next[receiver[k]]>now[receiver[k]]){
                    next[send[k]]=next[receiver[k]]-now[receiver[k]];
                    next[receiver[k]]=now[receiver[k]];
                }
                if(!visited[next[0]][next[1]]){
                    visited[next[0]][next[1]]=true;
                    queue.add(new AB(next[0],next[1]));
                    if(next[0]==0){
                        result[next[2]]=true;
                    }
                }
            }
        }
    }
}
class AB{
    int A;
    int B;

    public AB(int a, int b) {
        this.A = a;
        this.B = b;
    }
}