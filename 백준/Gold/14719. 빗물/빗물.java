import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        List<List<Integer>> arr = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        for(int i=0;i<=H;i++) {
            arr.add(new ArrayList<Integer>());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<W;i++){
            int block = Integer.parseInt(st.nextToken());

            for(int j=1;j<=block;j++){
                arr.get(j).add(i);
            }
        }
        int count =0;
        for(int i=1;i<=H;i++){
            List<Integer> integers = arr.get(i);

            for(int j=0;j<integers.size()-1;j++){
                int now = integers.get(j);
                int next = integers.get(j+1);
                int between = next-now-1;
                if(between > 0){
                    count += between;
                }
            }
        }
        System.out.println(count);
    }
}
