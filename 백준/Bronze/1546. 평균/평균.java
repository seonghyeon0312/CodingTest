import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int max_score = 0;
        int[] score = new int[cnt];
        int sum=0;
        for (int i = 0; i < cnt; i++) {
            score[i] = sc.nextInt();
            if (max_score < score[i]) {
                max_score = score[i];
            }
            sum+=score[i];
        }
        float avg;
        avg=sum*100;
        avg/=(float)max_score;
        avg/=(float)cnt;
        System.out.print(avg);
    }
}
