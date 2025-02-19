import java.util.HashMap;

class Solution {
    public boolean solution(String[] phoneBook) {
        HashMap<String, Boolean> map = new HashMap<>();
        
        // 1️⃣ 모든 전화번호를 HashMap에 저장
        for (String phoneNumber : phoneBook) {
            map.put(phoneNumber, true);
        }

        // 2️⃣ 각 전화번호의 접두어가 HashMap에 존재하는지 확인
        for (String phoneNumber : phoneBook) {
            for (int i = 1; i < phoneNumber.length(); i++) { // 접두어를 계속 잘라서 확인
                String prefix = phoneNumber.substring(0, i);
                if (map.containsKey(prefix)) { // HashMap에 접두어가 있으면 false 반환
                    return false;
                }
            }
        }
        
        return true; // 모든 검사를 통과하면 true 반환
    }
}