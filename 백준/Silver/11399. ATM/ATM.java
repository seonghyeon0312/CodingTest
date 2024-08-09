import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Integer[] num_list;
    static Integer[] sum_list;
    static List<Integer> result=new ArrayList<>();

    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        num_list=new Integer[n];
        sum_list=new Integer[n];
        for(int i=0;i<n;i++){
            num_list[i]=Integer.parseInt(st.nextToken());
        }

        insertionSort2();
//        num_list[0]=result.get(0);

        int sum=0;
//        sum+=num_list[0];
        for(int i=0;i<n;i++){
//            num_list[i]=num_list[i-1]+result.get(i);
//            sum+=num_list[i];
            sum+=sum_list[i];
        }
        System.out.println(sum);
    }

    /**
     * 원본 배열1개, 결과 저장용 리스트 1개를 사용
     * 그러므로 메모리가 더 많이 사용된다.
     * 대신 결과를 따로 리스트에 저장하기 때문에 자료구조적 특성으로 인해서 원본 배열의 크기가 커지면 커질 수록 속도가 빠르다
     */
    private static void insertionSort1() {
        result.add(num_list[0]);
        for(int i=1;i<n;i++){
            for(int j=0;j<result.size();j++){
                if(num_list[i]<result.get(j)){
                    result.add(j,num_list[i]);
                    break;
                }
            }
            if(result.size() == i) { // 아직 추가되지 않은 경우 끝에 추가
                result.add(num_list[i]);
            }
        }
    }

    /**
     * 하나의 배열을 가지고 정렬(제자리 정렬)
     * 메모리 사용량은 위 방식보다 적다.
     * 배열의 크기가 커지면 위 방식의 시간보다 오래 걸린다.
     */
    private static void insertionSort2(){
        for(int i=1;i<n;i++){
            int insert_point =i;
            int insert_value=num_list[i];

            for(int j=i-1;j>=0;j--){
                if(num_list[j]<num_list[i]){
                    insert_point=j+1;
                    break;
                }
                if(j==0){
                    insert_point=0;
                }
            }
            for(int j=i;j>insert_point;j--){
                num_list[j]=num_list[j-1];
            }
            num_list[insert_point]=insert_value;
        }
        sum_list[0]=num_list[0];
        for(int i=1;i<n;i++){
            sum_list[i]=sum_list[i-1]+num_list[i];
        }

    }
}