import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int dest = sc.nextInt();
        sc.close();

        boolean[] visited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int location = queue.poll();
                if (location == dest) {
                    System.out.println(count);
                    return;
                }
                if (location - 1 >= 0 && !visited[location - 1]) {
                    queue.add(location - 1);
                    visited[location - 1] = true;
                }
                if (location + 1 <= 100000 && !visited[location + 1]) {
                    queue.add(location + 1);
                    visited[location + 1] = true;
                }
                if (location * 2 <= 100000 && !visited[location * 2]) {
                    queue.add(location * 2);
                    visited[location * 2] = true;
                }
            }
            count++;
        }
    }
}