import java.util.Queue;
import java.util.LinkedList;

class Solution {
    Queue<Integer> queue = new LinkedList<>();
        public int solution(int[] priorities, int location) {
            int answer = 0;

            for(int num : priorities){
                queue.add(num);
            }

            while(location!=-1){
                int target = queue.poll();

                if(!checkOut(target)){
                    queue.add(target);
                    location--;
                    if(location<0)
                        location = queue.size()-1;
                }else{
                    answer++;
                    location--;
                }
            }

            return answer;
        }

        boolean checkOut(int number){
            for (Integer i : queue) {
                if(i>number)
                    return false;
            }
            return true;
        }
}