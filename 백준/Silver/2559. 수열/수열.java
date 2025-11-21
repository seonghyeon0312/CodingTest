import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        int[] numbers = new int[n];

        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
            if(i<k){
                sum+=numbers[i];
            }
        }

        int maxSum = sum;

        for(int i=k;i<n;i++){
            sum -= numbers[i-k];
            sum += numbers[i];

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}
