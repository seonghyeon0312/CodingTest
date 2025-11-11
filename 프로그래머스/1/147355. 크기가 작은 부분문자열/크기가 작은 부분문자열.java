class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long target = Long.parseLong(p);
        
        for(int i=0;i<= t.length() - len ; i++){
            String subString = t.substring(i, i+len);
            if(Long.parseLong(subString) <= target) answer++;
        }
        
        return answer;
    }
}