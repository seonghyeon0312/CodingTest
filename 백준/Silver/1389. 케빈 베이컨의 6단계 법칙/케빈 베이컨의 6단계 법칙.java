import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] w,d;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        w=new int[n+1][n+1];

        // graph, result 초기화
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            w[s][e]=1;
            w[e][s]=1;
        }

        floyd();

        int min=Integer.MAX_VALUE;
        int number=0;

        for(int i=1;i<=n;i++){
            int sum = Arrays.stream(w[i]).sum();
            if(min>sum){
                min=sum;
                number=i;
            }
        }
        System.out.println(number);
    }

    private static void floyd() {
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(w[i][k]>=1 && w[k][j]>=1){
                        if(w[i][j]==0){
                            w[i][j]=w[i][k]+w[k][j];
                        }else{
                            w[i][j]=Math.min(w[i][j],w[i][k]+w[k][j]);
                        }
                    }
                }
            }
        }
    }
}