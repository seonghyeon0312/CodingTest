import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> count = new HashMap<>(); // 값의 개수를 기록

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                // 삽입 연산: 두 힙에 넣고 카운트 증가
                minHeap.offer(num);
                maxHeap.offer(num);
                count.put(num, count.getOrDefault(num, 0) + 1);
            } 
            else if (command.equals("D")) {
                if (count.isEmpty()) continue; // 아무것도 없으면 무시

                if (num == 1) {
                    // 최댓값 삭제
                    removeValid(maxHeap, count);
                } else {
                    // 최솟값 삭제
                    removeValid(minHeap, count);
                }
            }
        }

        // 연산이 끝난 후에도 힙에 유령데이터가 있을 수 있으므로 정리
        int max = getValid(maxHeap, count);
        int min = getValid(minHeap, count);

        // 모두 삭제된 경우 처리
        if (count.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max, min};
    }

    // 힙에서 실제 존재하는 값 하나 삭제
    private void removeValid(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (count.containsKey(val)) {
                // 유효한 값이라면 카운트를 감소
                if (count.get(val) == 1) count.remove(val);
                else count.put(val, count.get(val) - 1);
                break;
            }
        }
    }

    // 힙에서 실제 존재하는 값 하나 반환
    private int getValid(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (count.containsKey(val)) {
                return val;
            }
        }
        return 0;
    }
}