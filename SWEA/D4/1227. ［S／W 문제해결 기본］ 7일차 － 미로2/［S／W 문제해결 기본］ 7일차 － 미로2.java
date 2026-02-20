import java.util.*;
import java.io.*;

public class Solution {
	static int[][] board;
	static boolean[][] visited;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int s=1;s<=10;s++) {
			int testCase = Integer.parseInt(br.readLine());
			board = new int[100][100];
			visited = new boolean[100][100];
			result = 0;
			int x=1, y=1;
			for(int i=0;i<100;i++) {
				String[] split = br.readLine().split("");
				for(int j=0;j<100;j++) {
					board[i][j] = Integer.parseInt(split[j]);
					if(board[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			bfs(x,y);
			System.out.println("#"+testCase+" "+result);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] cord = queue.poll();
			visited[cord[0]][cord[1]] = true;
			if(board[cord[0]][cord[1]] == 3) {
				result = 1;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = cord[0] + dx[i];
				int ny = cord[1] + dy[i];
				
				if(nx>=0 && ny>=0 && nx<100 && ny<100 && !visited[nx][ny] && board[nx][ny] != 1) {
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
