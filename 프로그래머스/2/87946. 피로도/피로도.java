class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        answer = backTracking(k, dungeons, visited,0,-1,0);
        
        return answer;
    }
    
    int backTracking(int k, int[][] dungeons, boolean[] visited, int depth, int result, int count){
        if(depth == visited.length){
            return Math.max(result, count);
        }
        
        for(int i=0;i<visited.length;i++){
            boolean isAvailable = false;
            if(!visited[i]){
                visited[i] = true;
                depth++;
                if(dungeons[i][0] <= k){
                    isAvailable = true;
                    k -= dungeons[i][1];
                    count+=1;
                }
                result = backTracking(k, dungeons, visited, depth, result, count);
                if(isAvailable){
                    k+=dungeons[i][1];
                    count-=1;
                }
                depth--;
                visited[i]=false;
            }
        }
        return result;
    }
}