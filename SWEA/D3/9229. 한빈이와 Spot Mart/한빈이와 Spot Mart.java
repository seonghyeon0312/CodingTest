import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int test_case=1;test_case<=t;test_case++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] snack=new int[n];
            for(int i=0;i<n;i++){
                snack[i]=sc.nextInt();
            }
            Arrays.stream(snack).sorted();
            int max_value=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(snack[i]+snack[j]<=m){
                        max_value=Math.max(max_value,snack[i]+snack[j]);
                    }
                }
            }
            if(max_value==Integer.MIN_VALUE){
                max_value=-1;
            }
            System.out.println("#"+test_case+" "+max_value);
        }
    }
}