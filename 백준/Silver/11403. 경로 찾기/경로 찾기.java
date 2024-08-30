import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] w;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());

        w=new int[n][n];

        // graph, result 초기화
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                w[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        
        floyd();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(w[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void floyd() {
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(w[i][k]==1 && w[k][j] ==1){
                        w[i][j]=1;
                    }
                }
            }
        }
    }
}