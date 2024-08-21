import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int n,m;
    static int[] nodeTrust;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph=new ArrayList[n+1];
        nodeTrust=new int[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        //graph 만들기
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());

            //신뢰 관계 업데이트, 반대 방향으로는 신뢰관계가 성립하지 않으므로 업데이트 안함
            graph[s].add(e);
        }

        // 하나의 노드에서 출발해서 갈 수 있는 노드 갯수 구하기 - 넓이 우선 탐색으로 개수 구하기
        for(int i=1;i<=n;i++) {
            visited = new boolean[n + 1];
            BFS(i);
        }
        List<Integer> result=new ArrayList<>();
        int maxValue=0;
        for(int i=1;i<=n;i++){
            maxValue=Math.max(maxValue,nodeTrust[i]);
        }

        for(int i=1;i<=n;i++){
            if(nodeTrust[i]==maxValue){
                System.out.print(i+" ");
            }
        }
    }

    private static void BFS(int start){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            Integer getNode=queue.poll();
            for (Integer i : graph[getNode]) {
                if(visited[i]==false){
                    visited[i]=true;
                    nodeTrust[i]++;
                    queue.add(i);
                }
            }
        }
    }
}