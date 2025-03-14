import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int score = Integer.parseInt(st.nextToken());
        
        if(score >=90 && score<=100)
            System.out.print("A");
        else if(score >=80 && score<90)
            System.out.print("B");
        else if(score >=70 && score<80)
            System.out.print("C");
        else if(score >=60 && score<70)
            System.out.print("D");
        else
            System.out.print("F");
    }
}