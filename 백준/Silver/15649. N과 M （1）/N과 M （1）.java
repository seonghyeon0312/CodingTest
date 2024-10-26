import java.util.*;
import java.io.*;

public class Main {
    public static int [] index;
    public static int [] output;
    public static int n,r;
    public static boolean [] visited;
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        r=sc.nextInt();

        output=new int[r];
        visited=new boolean[n+1];

        perm(0);
    }
    //순열
    public static void perm(int cnt) {
        if(cnt==r) {
            //뽑힌 인덱스의 목록
            String result = toString(output);
            System.out.println(result);
            return;
        }
        for(int i=1;i<=n;i++) {
            if(visited[i]) continue;
            output[cnt]=i;
            visited[i]=true;
            perm(cnt+1);
            visited[i]=false;
        }
    }

    public static String toString(int[] output){
        StringJoiner sj = new StringJoiner(" ");

        for (Integer i : output) {
            String result = i.toString();
            sj.add(result);
        }
        return sj.toString();
    }

}