import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collection;

public class Solution {
    static LinkedList<Integer> linked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case=1;test_case<=10;test_case++) {
            int N=sc.nextInt();
            linked=new LinkedList<>();
            for(int i=0;i<N;i++){
                linked.add(sc.nextInt());
            }
            int M=sc.nextInt();
            for(int i=0;i<M;i++){
                String order=sc.next();
                if(order.equals("I")){
                    int x=sc.nextInt();
                    int y=sc.nextInt();
                    Collection<Integer> temp=new LinkedList<Integer>();
                    for(int j=0;j<y;j++){
                        temp.add(sc.nextInt());
                    }
                    linked.addAll(x,temp);
                }else if(order.equals("D")){
                    int x=sc.nextInt();
                    int y=sc.nextInt();
                    for(int j=x;j<x+y;j++){
                        linked.remove(j);
                    }
                }else if(order.equals("A")){
                    int y=sc.nextInt();
                    Collection<Integer> temp=new LinkedList<>();
                    for(int j=0;j<y;j++){
                        temp.add(sc.nextInt());
                    }
                    linked.addAll(temp);
                }
            }
            System.out.print("#"+test_case);
            for(int j=0;j<10;j++){
                System.out.print(" "+linked.get(j));
            }
            System.out.println();
        }
    }

}