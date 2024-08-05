import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer=
                new StringTokenizer(bufferedReader.readLine());
        int suNo=Integer.parseInt(stringTokenizer.nextToken());
        int quizNo=Integer.parseInt(stringTokenizer.nextToken());
        long[] S=new long[suNo+1];
        stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        for(int i=1;i<=suNo;i++){
            S[i]=S[i-1]+Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int j=0;j<quizNo;j++){
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            int i=Integer.parseInt(stringTokenizer.nextToken());
            int q=Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[q]-S[i-1]);
        }
    }
}
