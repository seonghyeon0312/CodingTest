import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static List<Integer> distance = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for(int i=0;i<=n;i++){
            distance.add(50001);
            graph.add(new ArrayList<>());
        }
        
        distance.set(1, 0);
        
        for(int[] vertex : edge){
            graph.get(vertex[0]).add(vertex[1]);
            graph.get(vertex[1]).add(vertex[0]);
        }
    
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(Integer next : graph.get(node)){
                if(visited[next]) continue;
                distance.set(next, distance.get(node)+1);
                visited[next] = true;
                queue.add(next);
            }
        }
        
        int maxDistance = -1;
        for(Integer dist : distance){
            if(dist == 50001) continue;
            if(dist > maxDistance){
                answer= 1;
                maxDistance = dist;
            }else if(dist==maxDistance){
                answer++;
            }
        }
        
        return answer;
    }
    
    
}