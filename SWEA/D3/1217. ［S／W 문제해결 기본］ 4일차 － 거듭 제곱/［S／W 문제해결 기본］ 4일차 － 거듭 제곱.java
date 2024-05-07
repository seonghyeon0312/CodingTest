import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case=1;test_case<=10;test_case++) {
            int test=sc.nextInt();
            int number=sc.nextInt();
            int time=sc.nextInt();
            int result=1;
            System.out.println("#"+test+" "+Pow(number,time,result));
        }
    }
    public static int Pow(int number, int time, int result){
        if(time==0){
            return result;
        }else{
            result*=number;
            time--;
            return Pow(number,time,result);
        }

    }
}