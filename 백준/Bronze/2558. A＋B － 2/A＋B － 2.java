import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sum =Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        sum+=Integer.parseInt(st.nextToken());
        System.out.println(sum);
    }

}
