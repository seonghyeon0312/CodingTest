import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> marathon = new HashMap<>();
        
        for(String name : participant){
            if(marathon.containsKey(name)){
                Integer count = marathon.get(name);
                marathon.replace(name, count+1);
            }else{
                marathon.put(name,1);
            }
        }
        
        for(String name : completion){
            Integer count = marathon.get(name);
            
            if(count == 1){
                marathon.remove(name);
            }else{
                marathon.replace(name,count-1);
            }
        }
        
        answer = marathon.keySet().toString();
        
        answer = answer.substring(1,answer.length()-1);
        return answer;
    }
}