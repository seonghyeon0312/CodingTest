import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int[] num;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        num=new int[n+1];
        for(int i=0;i<=n;i++){
            num[i]=i;
        }

        for(int k=0;k<m;k++){
            st=new StringTokenizer(bf.readLine());
            if(st.nextToken().equals(String.valueOf('0'))){
                Union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            } else{
                Find(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
        }
    }
    public static void Union(int num1, int num2){
        int result1;
        int result2;

        if((num[num1]==num1)&&(num[num2]==num2)){
            num[num2]=num[num1];
        }else{
            //재귀로 각 원소의 대표 노드 찾기
            result1=_find(num1);
            result2=_find(num2);
            num[result2]=num[result1];
        }
    }
    public static void Find(int num1, int num2){
        int find_num1=_find(num1);
        int find_num2=_find(num2);
        if(find_num2==find_num1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    private static int _find(int num1){
        if(num[num1]!=num1){
            num[num1]=_find(num[num1]);
        }
        return num[num1];
    }
}