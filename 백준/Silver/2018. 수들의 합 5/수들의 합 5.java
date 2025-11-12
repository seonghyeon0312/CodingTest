import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] natural = new int[n+1];
        
        for(int i=1;i<=n;i++){
            natural[i]=i;
        }
        
        int left = 1;
        int right = 1;
        int sum = natural[1];
        int count = 0;
        while(right <= n && left <= n){
            if(sum < n){
                right++;
                if (right > n) break;
                sum+=natural[right];
            }else if(sum>n){
                sum-=natural[left];
                left++;
            }else{
                count++;
                sum-=natural[left];
                left++;
            }
        }
        System.out.println(count);
    }
}