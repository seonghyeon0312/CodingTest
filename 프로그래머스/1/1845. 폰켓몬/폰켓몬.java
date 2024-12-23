import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer,Integer> phoneKetMon = new HashMap<>();

        for (int num : nums) {
            if(phoneKetMon.containsKey(num)){
                Integer i = phoneKetMon.get(num);
                phoneKetMon.replace(num,i+1);
            }else{
                phoneKetMon.put(num,1);
            }
        }

        answer = nums.length/2;

        if(phoneKetMon.size() < answer){
            answer = phoneKetMon.size();
        }
        
        return answer;
    }
}