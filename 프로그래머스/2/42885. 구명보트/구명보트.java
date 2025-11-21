import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 정렬: 가장 가벼운 + 가장 무거운 조합을 찾기 위함

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // 가장 가벼운 사람 + 가장 무거운 사람 함께 가능한 경우
            if (people[left] + people[right] <= limit) {
                left++;       // 가벼운 사람 태움
            }
            // 무거운 사람은 항상 태움
            right--;
            boats++;
        }

        return boats;
    }
}