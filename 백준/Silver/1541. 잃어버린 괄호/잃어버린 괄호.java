import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int result = 0;
        String[] mathExpression = st.nextToken().split("-");
//        result=Integer.parseInt(mathExpression[0]);
        for(int i=0;i<mathExpression.length;i++){
            int sum=0;
            if(mathExpression[i].contains("+")){
                String[] split = mathExpression[i].split("[+]");
                for (String s : split) {
                    sum+=Integer.parseInt(s);
                }
            }else{
                sum=Integer.parseInt(mathExpression[i]);
            }
            if(i==0){
                result+=sum;
            }else{
                result-=sum;
            }
        }
        System.out.println(result);
    }
}