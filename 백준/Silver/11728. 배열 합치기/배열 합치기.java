import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            arr1.add(sc.nextInt());
        }

        for(int i=0;i<m;i++){
            arr2.add(sc.nextInt());
        }

        arr1.addAll(arr2);
        arr1.sort(Integer::compareTo);

        StringJoiner sj = new StringJoiner(" ");
        for (Integer i : arr1) {
            sj.add(Integer.toString(i));
        }

        System.out.print(sj);
    }
}