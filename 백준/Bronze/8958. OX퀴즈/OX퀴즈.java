import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i=0;i<testCase;i++){
            String[] target = sc.next().split("");
            System.out.println(cal(target));
        }
    }

    private static int cal(String[] target){
        int score = 0;
        int result = 0;

        for (String tar : target) {
            if(tar.equals("O")){
                score++;
                result+=score;
            }else if(tar.equals("X")){
                score=0;
            }
        }

        return result;
    }
}