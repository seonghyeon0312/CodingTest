import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                queue.add(i);
                while(!queue.isEmpty()){
                    int computer = queue.poll();
                    visited[computer]=true;
                    
                    for(int j=0;j<n;j++){
                        if(j==computer) continue;
                        if(!visited[j] && computers[computer][j]==1) queue.add(j);
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}