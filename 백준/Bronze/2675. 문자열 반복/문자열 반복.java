import java.util.Scanner;
import java.util.HashMap;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int i=0;i<test;i++){
            int repeat = sc.nextInt();
            String[] target = sc.next().split("");
            StringJoiner sj = new StringJoiner("");
            for(String n : target){
                for(int j=0;j<repeat;j++){
                    sj.add(n);
                }
            }
            System.out.println(sj);
        }
    }
}