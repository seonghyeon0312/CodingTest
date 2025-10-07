import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, Integer> outDegree = new HashMap<>();
    int[] count = new int[4]; 
    
    public int[] solution(int[][] edges) {
        
        for (int[] edge : edges) {
            int start = edge[0];
            int dest = edge[1];

            // 그래프 연결
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest, k -> new ArrayList<>());

            // degree 계산
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(dest, inDegree.getOrDefault(dest, 0) + 1);

            // 혹시 값이 없는 노드는 0으로 초기화
            inDegree.putIfAbsent(start, inDegree.getOrDefault(start, 0));
            outDegree.putIfAbsent(dest, outDegree.getOrDefault(dest, 0));
        }
        
        int hub = -1;
        for (int node : graph.keySet()) {
            int in = inDegree.getOrDefault(node, 0);
            int out = outDegree.getOrDefault(node, 0);

            if (in == 0 && out >= 2) {
                hub = node;
                break;
            }
        }
        
        count[0] = hub;

        for(int next : graph.get(hub)){
            dfs(next, new HashSet<>(), next);
        }

        
        return count;
    }
    
        private void dfs(int node, Set<Integer> visited, int start) {
        if (visited.contains(node)) {
            // 사이클 도달 → 도넛형
            count[1]++;
            return;
        }

        visited.add(node);

        List<Integer> nexts = graph.get(node);
        if (nexts.isEmpty()) {
            // 나가는 간선이 없음 → 막대형
            count[2]++;
            return;
        }

        if (nexts.size() >= 2) {
            // 분기 발생 → 8자형
            count[3]++;
            return;
        }

        // 다음 노드로 이동
        dfs(nexts.get(0), visited, start);
    }

}