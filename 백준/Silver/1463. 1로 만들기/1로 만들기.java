import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int inputInteger = Integer.parseInt(st.nextToken());

        int[] arrays = new int[inputInteger+1];

        for(int i=2;i<arrays.length;i++){
            arrays[i]=arrays[i-1]+1;
            if(i % 2 == 0){
                arrays[i]=Math.min(arrays[i], arrays[i/2]+1);
            }
            if(i%3==0){
                arrays[i]=Math.min(arrays[i],arrays[i/3]+1);
            }
        }

        System.out.println(arrays[inputInteger]);
    }
}