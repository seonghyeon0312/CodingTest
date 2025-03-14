import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cord = new int[4];

        for(int i=0;i<4;i++){
            cord[i]=sc.nextInt();
        }

        int minX = Math.min(cord[0], cord[2] - cord[0]);
        int minY = Math.min(cord[1],cord[3]-cord[1]);
        System.out.println(Math.min(minY,minX));
    }
}