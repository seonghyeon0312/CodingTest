import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arrays = new int[1001];
        arrays[1]=1;
        arrays[2]=2;
        
        for(int i=3;i<=N;i++){
            arrays[i]=(arrays[i-1]+arrays[i-2]) % 10007;
        }
        
        System.out.println(arrays[N]);
    }
}