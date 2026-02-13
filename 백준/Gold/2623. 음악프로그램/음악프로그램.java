import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int n, m;
	static int[] indegree;
	static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        indegree = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
        	graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
        	st = new StringTokenizer(br.readLine());
        	int k = Integer.parseInt(st.nextToken());
        	int prev = Integer.parseInt(st.nextToken());
        	for(int j=1;j<k;j++) {
        		int next = Integer.parseInt(st.nextToken());
        		indegree[next]++;
        		graph.get(prev).add(next);
        		prev = next;
        	}
        }
        
        topo();
        
    }
    
    public static void topo() {
    	Queue<Integer> queue = new LinkedList<>();
    	
    	for(int i=1;i<=n;i++) {
    		if(indegree[i]==0) queue.add(i);
    	}
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
    	while(!queue.isEmpty()) {
    		Integer node = queue.poll();
    		cnt++;
    		sb.append(node).append("\n");
    		
    		for(Integer next : graph.get(node)) {
    			if(--indegree[next] == 0) queue.add(next);
    		}
    	}
    	if(cnt != n) {
    		System.out.println(0);
    		return;
    	}
    	System.out.println(sb.toString());
    }
}