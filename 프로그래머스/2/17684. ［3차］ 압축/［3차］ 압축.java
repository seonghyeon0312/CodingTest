import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String,Integer> dict = new HashMap<>();
        int idx = 65;
        
        for(int i=1;i<27;i++){
            dict.put(Character.toString((char)idx), i);
            idx++;
        }
        idx = 27;
        String[] splitMsg = msg.split("");
        
        for(String ch : splitMsg){
            queue.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            sb.append(queue.pollFirst());
            
            if(dict.containsKey(sb.toString())){
                if(queue.isEmpty()){
                    answer.add(dict.get(sb.toString()));
                }else{
                    continue;
                }
            }else{
                dict.put(sb.toString(), idx);
                idx++;
                queue.addFirst(Character.toString(sb.charAt(sb.length()-1)));
                sb.deleteCharAt(sb.length()-1);
                answer.add(dict.get(sb.toString()));
                sb.setLength(0);
            }
        }
        
        int[] arr = answer.stream().mapToInt(Integer::intValue).toArray();
        
        return arr;
    }
}