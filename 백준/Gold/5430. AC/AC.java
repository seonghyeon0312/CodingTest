import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=
                new StringTokenizer(bf.readLine());
        int t=Integer.parseInt(st.nextToken());
        for(int i=1;i<=t;i++){
            Deque<Integer> deque=new LinkedList<>();
            int n;
            boolean err=false;
            boolean reverse=false;
            st=new StringTokenizer(bf.readLine());
            String[] fuc=st.nextToken().split("");
            st=new StringTokenizer(bf.readLine());
            n=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(bf.readLine());
            String temp=st.nextToken();
            temp=temp.substring(1,temp.length()-1);
            String[] lists=temp.split(",");
            if(n!=0){
                for(String ele:lists){
                    if (ele.equals("[") || ele.equals("]")||ele.equals(",")) {
                        continue;
                    }
                    deque.add(Integer.parseInt(ele));
                }
                for(String ele:fuc){
                    if(ele.equals("R")){
                        if(reverse){
                            reverse=false;
                        }else{
                            reverse=true;
                        }
                    }else if(ele.equals("D")){
                        if(deque.isEmpty()){
                            err=true;
                            break;
                        }
                        if(!reverse){
                            deque.poll();
                        }else{
                            deque.pollLast();
                        }
                    }
                }
                if(err){
                    System.out.println("error");
                    deque.clear();
                    continue;
                }
                if(reverse){
                    Collections.reverse((LinkedList<Integer>) deque);
                    Integer[] deque_list=deque.toArray(new Integer[0]);
                    System.out.println(Arrays.toString(deque_list).replace(" ",""));
                }else{
                    Integer[] deque_list=deque.toArray(new Integer[0]);
                    System.out.println(Arrays.toString(deque_list).replace(" ",""));
                }
                deque.clear();
            }else{
                for(String ele:fuc){
                    if(ele.equals("D")){
                        err=true;
                        break;
                    }
                }
                if(err){
                    System.out.println("error");
                }else{
                    System.out.println("[]");
                }
            }
        }
    }
}
