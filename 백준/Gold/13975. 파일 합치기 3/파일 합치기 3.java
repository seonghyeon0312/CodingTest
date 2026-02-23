import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 최소 힙 사용
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            // 입력 받으면서 바로 힙에 추가
            for (int i = 0; i < k; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            
            long totalCost = 0;
            
            // 파일이 1개 남을 때까지 합치기
            while (pq.size() > 1) {
                long file1 = pq.poll();
                long file2 = pq.poll();
                long mergeCost = file1 + file2;
                
                totalCost += mergeCost;
                pq.offer(mergeCost);
            }
            
            sb.append(totalCost).append('\n');
        }
        
        System.out.print(sb);
    }
}