import java.util.Scanner;

public class Main{
    static int[] numbers;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];

        for(int i=0;i<N;i++){
            numbers[i] = i+1;
        }

        StringBuilder sb = new StringBuilder();

        backTracking(sb, 0,0);
    }

    static void backTracking(StringBuilder sb, int count, int start){
        if(count == M){
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i=start;i<N;i++){
            sb.append(numbers[i]);
            sb.append(" ");
            backTracking(sb, count+1, i+1);
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}