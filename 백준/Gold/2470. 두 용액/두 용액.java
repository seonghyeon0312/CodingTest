import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Integer> liquidPh = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            liquidPh.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(liquidPh);

        int left = 0;
        int right = n-1;
        int minValue = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(left<right){
            int value = liquidPh.get(left) + liquidPh.get(right);
            int absValue = Math.abs(value);

            if(absValue < minValue ){
                minValue = absValue;
                result[0] = liquidPh.get(left);
                result[1] = liquidPh.get(right);
            }

            if( value < 0){
                left++;
            }else if(value > 0){
                right--;
            }else{
                break;
            }
        }

        System.out.print(result[0] + " " + result[1]);
    }
}
