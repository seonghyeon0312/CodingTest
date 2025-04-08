import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testcase = Integer.parseInt(st.nextToken());
        for(int i=0;i<testcase;i++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer[]> array = new ArrayList<>();
            for(int j=0;j<n;j++){
                st = new StringTokenizer(bf.readLine());
                array.add(new Integer[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }
            array.sort(Comparator.comparingInt(a -> a[0]));
            boolean[] result = new boolean[n];
            Arrays.fill(result,true);
            int count =1;
            Integer minValue = array.get(0)[1];
            for(int j=1;j<n;j++){
                if(minValue<array.get(j)[1]){
                    result[j]=false;
                }else{
                    minValue=array.get(j)[1];
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}