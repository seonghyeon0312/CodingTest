import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main  {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ropes = new ArrayList<>();

        int n = Integer.parseInt(bf.readLine().trim());

        for(int i=0;i<n;i++){
            ropes.add(Integer.parseInt(bf.readLine().trim()));
        }

        ropes.sort(Comparator.naturalOrder());

        int maxWeight = Integer.MIN_VALUE;
        int idx = 0;
        for(Integer weight : ropes){
            maxWeight = Math.max(maxWeight, weight*(n-idx++));
        }

        System.out.println(maxWeight);
    }
}
