import java.util.Scanner;
import java.math.BigInteger;
public class Main{
    static int n;
    static BigInteger[] fibo;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        fibo = new BigInteger[n+2];
        fibo[0]=new BigInteger("0");
        fibo[1]=new BigInteger("1");
        BigInteger modValue = new BigInteger("15746");
        for(int i=2;i<=n+1;i++){
            fibo[i]=((fibo[i-1]).add(fibo[i-2])).mod(modValue);
        }

        System.out.println(fibo[n+1]);
    }
}