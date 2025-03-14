import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        for(int i=0;i<5;i++){
            switch(i){
                case 0:
                    System.out.println(first+second);
                    break;
                case 1:
                    System.out.println(first-second);
                    break;
                case 2:
                    System.out.println(first*second);
                    break;
                case 3:
                    System.out.println(first/second);
                    break;
                case 4:
                    System.out.println(first%second);
                    break;
            }
        }
    }

}
