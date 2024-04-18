import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] A=new int[n];
        int end=0;
        int start=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            A[i]=num;
            end+=num;
            start=Math.max(start,A[i]);
        }
        while(start<=end){
            int middle=(start+end)/2;
            int cnt=0;
            int sum_lesson=0;
            for(int i=0;i<n;i++){
                if(sum_lesson+A[i]>middle){
                    cnt++;
                    sum_lesson=0;
                }
                sum_lesson+=A[i];
            }
            if(sum_lesson!=0){
                cnt++;
            }
            if(cnt>m)
                start=middle+1;
            else
                end=middle-1;
        }
        System.out.print(start);
    }
}