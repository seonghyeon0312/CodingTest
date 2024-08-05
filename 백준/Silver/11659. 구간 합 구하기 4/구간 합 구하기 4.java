import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int n,q;
        n=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());
        int[] sum_array=new int[n];
        int tmp;
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            tmp=Integer.parseInt(st.nextToken());
            if(i==0){
                sum_array[0]=tmp;
            }else{
                sum_array[i]=sum_array[i-1]+tmp;
            }
        }
        int i,j;
        for(int k=0;k<q;k++){
            st=new StringTokenizer(bf.readLine());
            i= Integer.parseInt(st.nextToken())-1;
            j=Integer.parseInt(st.nextToken())-1;

            if(i==0){
                System.out.println(sum_array[j]);
            }else{
                System.out.println(sum_array[j]-sum_array[i-1]);
            }
        }
    }
}