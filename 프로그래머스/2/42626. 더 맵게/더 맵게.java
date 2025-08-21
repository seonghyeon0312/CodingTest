import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Food> queue = new PriorityQueue<>();

            for(int value : scoville){
                queue.add(new Food(value));
            }
                    
            int count =0;
            
            while(!queue.isEmpty() && queue.peek().scoville < K){
                Food food1 = queue.poll();
                if(queue.isEmpty()){
                    count = -1;
                    break;
                }
                Food food2 = queue.poll();

                int newScoville = food1.scoville + (food2.scoville * 2);

                queue.add(new Food(newScoville));
                count+=1;
            }
            
            return count;
    }
    
    class Food implements Comparable<Food>{

            int scoville;

            Food(int scoville){
                this.scoville = scoville;
            }
            @Override
            public int compareTo(Food o) {
                if(this.scoville > o.scoville){
                    return 1;
                }else if(this.scoville == o.scoville){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        }
}