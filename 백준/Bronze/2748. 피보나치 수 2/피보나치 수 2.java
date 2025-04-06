import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    static int n;
    static BigInteger[] fibo;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fibo = new BigInteger[n+1];
        fibo[0]=new BigInteger("0");
        fibo[1]=new BigInteger("1");

        for(int i=2;i<=n;i++){
            fibo[i]=fibo[i-2].add(fibo[i-1]);
        }

        System.out.println(fibo[n]);
    }

}