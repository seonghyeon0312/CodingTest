import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] w;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());

        w=new int[n+1][];

        for(int i=1;i<=n;i++){
            w[i]=new int[n+1];
        }

        // graph, result 초기화
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    w[i][j]=0;
                } else{
                    w[i][j]=Integer.MAX_VALUE/2;
                }
            }
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            if(w[s][e]>value) w[s][e]=value;
        }

        floyd();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(w[i][j]==Integer.MAX_VALUE/2){
                    System.out.print(0+" ");
                }else{
                    System.out.print(w[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    private static void floyd() {
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    w[i][j]=Math.min(w[i][j],w[i][k]+w[k][j]);
                }
            }
        }
    }
}