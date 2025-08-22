import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static List<int[]> empties = new ArrayList<>();  // 0인 좌표들
    static List<int[]> viruses = new ArrayList<>();  // 2인 좌표들
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    empties.add(new int[]{i, j});
                    zeroCount++;
                } else if (board[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        int best = solve();
        System.out.println(best);
    }

    // 조합 i<j<k 로만 생성 → 중복(순열) 방지
    private static int solve() {
        int e = empties.size();
        int ans = 0;
        for (int i = 0; i < e; i++) {
            for (int j = i + 1; j < e; j++) {
                for (int k = j + 1; k < e; k++) {
                    int[] w1 = empties.get(i);
                    int[] w2 = empties.get(j);
                    int[] w3 = empties.get(k);
                    int infected = spreadWithWalls(w1, w2, w3);
                    int safe = zeroCount - 3 - infected;
                    if (safe > ans) ans = safe;
                }
            }
        }
        return ans;
    }

    // 보드를 복사하지 않고, 선택한 3개의 벽 좌표를 차단으로 간주하여 BFS로 감염 수만 센다.
    private static int spreadWithWalls(int[] w1, int[] w2, int[] w3) {
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 바이러스 시작점 다 넣기
        for (int[] v : viruses) {
            q.offer(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }

        int infected = 0; // 0이었던 칸 중 감염된 수

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;

                // 기존 벽이거나, 새로 세운 3개 벽이면 진행 불가
                if (board[nx][ny] == 1) continue;
                if (isWall(nx, ny, w1, w2, w3)) continue;

                visited[nx][ny] = true;
                if (board[nx][ny] == 0) infected++; // 빈 칸을 처음 감염시킴
                q.offer(new int[]{nx, ny});
            }
        }
        return infected;
    }

    private static boolean isWall(int x, int y, int[] w1, int[] w2, int[] w3) {
        return (x == w1[0] && y == w1[1]) ||
               (x == w2[0] && y == w2[1]) ||
               (x == w3[0] && y == w3[1]);
    }
}