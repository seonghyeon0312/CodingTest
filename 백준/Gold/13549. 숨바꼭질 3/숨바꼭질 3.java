import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class Node{
        int index;
        int value;
        public Node(int i,int v){
            this.index=i;
            this.value=v;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<Node> queue=new LinkedList<>();
        int n=sc.nextInt();
        int k=sc.nextInt();
        if(n>k){
            System.out.println(n-k);
            return;
        }

        boolean[] visited=new boolean[1000001];
        int min=Integer.MAX_VALUE;
        visited[n]=true;
        queue.add(new Node(n,0));

        while(!queue.isEmpty()){
            Node node=queue.poll();
            visited[node.index]=true;
            if(node.index==k) {
                min=Math.min(min,node.value);
            }
            if(node.index*2<=100000 && !visited[node.index*2]){
                queue.offer(new Node(node.index*2, node.value));
            }
            if(node.index+1<=100000&&!visited[node.index+1]){
                queue.offer(new Node(node.index+1,node.value+1));
            }
            if(node.index-1>=0&&!visited[node.index-1]){
                queue.offer(new Node(node.index-1,node.value+1));
            }
        }
        System.out.println(min);
    }
}
