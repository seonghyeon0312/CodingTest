import java.util.*;

class Solution {
    Queue<Integer> queue = new LinkedList<>();
        int total;
        public int[] solution(int[] progresses, int[] speeds){
            List<Integer> result = new ArrayList<>();
            total = progresses.length;

            for(int i : progresses){
                queue.add(i);
            }

            while(!queue.isEmpty()){
                updateProgress(speeds);
                if(queue.peek() == 100){
                    int count = countQueue();
                    result.add(count);
                }
            }
            int[] answer = result.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }
        int countQueue(){
            int count =0;
            while(!queue.isEmpty() && queue.peek()==100){
                queue.poll();
                count++;
            }
            return count;
        }
        void updateProgress(int[] speeds){
            int index = total - queue.size();

            for(int i = index; i<speeds.length;i++){
                int num = queue.poll()+speeds[i];
                if(num>100)
                    num=100;
                queue.add(num);
            }
        }
}