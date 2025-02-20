import java.util.Arrays;
public class Solution{
        int count =0 ;
        public int solution(int[] numbers, int target) {
            final int sum = Arrays.stream(numbers).sum();

            if(sum == target)
                return 1;
            else if(sum < target)
                return 0;
            else{
                DFS(numbers, target, 0,0);
            }
            return count;
        }
        // DFS: 현재 인덱스와 현재 합을 유지하면서 탐색
        void DFS(int[] numbers, int target, int index, int nowSum) {
            // 모든 숫자를 다 사용했을 때
            if (index == numbers.length) {
                if (nowSum == target) {
                    count++; // 경우의 수 증가
                }
                return;
            }

            // 현재 숫자를 더하는 경우
            DFS(numbers, target, index + 1, nowSum + numbers[index]);

            // 현재 숫자를 빼는 경우
            DFS(numbers, target, index + 1, nowSum - numbers[index]);
        }
    }