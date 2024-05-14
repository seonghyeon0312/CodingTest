import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int t,k;
    static boolean[] visited;
    static Deque<Integer>[] deque;
    static int[][] map;
    static Queue<int[]> queue=new LinkedList<>();
    static Queue<int[]> turn_que=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        t=Integer.parseInt(st.nextToken());
        map=new int[t+1][9];
        deque=new Deque[t+1];
        for(int i=0;i<=t;i++){
            deque[i]=new LinkedList<>();
        }
        for(int i=1;i<=t;i++){
            st=new StringTokenizer(bf.readLine());
            String[] arr=st.nextToken().split("");
            int j=1;
            for(String ele: arr){
                map[i][j]=Integer.parseInt(ele);
                deque[i].add(Integer.parseInt(ele));
                j++;
            }
            j=1;
        }

        st=new StringTokenizer(bf.readLine());
        k=Integer.parseInt(st.nextToken());
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine());
            int num=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            queue.offer(new int[] {num,j});
        }
        Round();
    }
    public static void Round(){
        while(!queue.isEmpty()){
            int[] tmp=queue.poll();
            turn_que.clear();
            visited=new boolean[t+1];
            visited[tmp[0]]=true;
            can(tmp[0],tmp[1]);
            while(!turn_que.isEmpty()){
                int[] turn=turn_que.poll();
                if(turn[1]==1){
                    int last=deque[turn[0]].pollLast();
                    deque[turn[0]].addFirst(last);
                    int k=1;
                    for(int ele:deque[turn[0]]){
                        map[turn[0]][k]=ele;
                        k++;
                    }
                    k=1;
                }else{
                    int first=deque[turn[0]].pollFirst();
                    deque[turn[0]].addLast(first);
                    int k=1;
                    for(int ele:deque[turn[0]]){
                        map[turn[0]][k]=ele;
                        k++;
                    }
                    k=1;
                }
            }
        }
        int result=0;
        for(int i=1;i<=t;i++){
            if(deque[i].pollFirst()==1){
                result++;
            }
        }
        System.out.println(result);
    }
    public static void can(int num,int k){
        turn_que.add(new int[] {num,k});
        if(num-1>=1&&!visited[num-1]&&map[num][7]!=map[num-1][3]){
            visited[num-1]=true;
            can(num-1,k*-1);
        }
        if(num+1<=t&&!visited[num+1]&&map[num][3]!=map[num+1][7]){
            visited[num+1]=true;
            can(num+1,k*-1);
        }
    }
}