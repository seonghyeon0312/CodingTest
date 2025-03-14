import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] time = Integer.toString(sc.nextInt()*sc.nextInt()*sc.nextInt()).split("");

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<10;i++){
            map.put(i,0);
        }

        for (String s : time) {
            final int i = Integer.parseInt(s);
            Integer oldValue = map.get(i);
            map.replace(i,++oldValue);
        }

        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }
}