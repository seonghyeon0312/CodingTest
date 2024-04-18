import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Boolean> A;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        A=new HashMap<>();
        for(int i=0;i<n;i++){
            A.put(sc.nextInt(),true);
        }
        int m=sc.nextInt();

        for(int i=0;i<m;i++){
            if(A.containsKey(sc.nextInt())){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}