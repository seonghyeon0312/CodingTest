import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        String tmp;
        Integer result=0;
        n=sc.nextInt();
        tmp=sc.next();

        for(String s : tmp.split("")){
            result += Integer.parseInt(s);
        }
        System.out.print(result);
    }
}