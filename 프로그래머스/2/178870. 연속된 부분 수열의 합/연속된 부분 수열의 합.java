
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = 0;
        int n = sequence.length;
        int minLen = Integer.MAX_VALUE;
        int sum = sequence[0];
        
        while(true){
            if(sum < k){
                right++;
                if(right == n) break;
                sum += sequence[right];
            }    
            else if(sum > k){
                sum-=sequence[left];
                left++;
            }
            else {
                int length = right - left;
                if(length < minLen){
                    minLen = length;
                    answer[0] = left;
                    answer[1] = right; 
                }
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;   
    }
}