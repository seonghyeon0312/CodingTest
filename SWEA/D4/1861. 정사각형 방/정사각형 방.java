import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Solution {

	static int n;
	static int maxValue = -1;
	static int roomNum = Integer.MAX_VALUE; 
	static List<List<Integer>> graph = new ArrayList<>();
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	n = Integer.parseInt(br.readLine());
        	graph = new ArrayList<>();
        	maxValue = -1;
        	roomNum = Integer.MAX_VALUE;
        	int[][] board = new int[n][n];
        	for(int i=0;i<=n*n;i++) {
        		graph.add(new ArrayList<>());
        	}
        	
        	for(int i=0;i<n;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0;j<n;j++) {
        			board[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			int idx = board[i][j];
        			
        			List<Integer> near = graph.get(idx);
        			
        			for(int k=0;k<4;k++){
        				int nx = i + dir[k][0];
        				int ny = j + dir[k][1];
        				
        				if(nx<0 || ny <0 || nx>=n || ny>=n) continue;
        				
        				if(board[nx][ny] - idx == 1) near.add(board[nx][ny]);
        			}
        		}
        	}
        	
        	visited = new boolean[n*n+1];
        	for(int i=1;i<=n*n;i++) {
        		dfs(i, i, 1);
        	}
        	
            System.out.println("#" + test_case + " " + roomNum + " "+maxValue);
        }
    }
    
    public static void dfs(int idx, int start, int cnt) {
    	if(visited[idx]) return;
    	if(graph.get(idx).isEmpty()) {
    		visited[idx] = true;
    		if(maxValue < cnt) {
    			maxValue = cnt;
    			roomNum = start;
    		}
    		return;
    	}
    	visited[idx] = true;
    	dfs(graph.get(idx).get(0), start, cnt+1);
    }
}