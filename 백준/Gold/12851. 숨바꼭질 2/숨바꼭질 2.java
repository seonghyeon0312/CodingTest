import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int count = 0;

        if(start>end){
            System.out.println(start-end);
            System.out.println(1);
            return;
        }

        boolean[] visited = new boolean[100001];
        visited[start] = true;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.index] = true;

            if(node.index == end){
                if(min > node.value){
                    count = 1;
                    min = node.value;
                }else if(min == node.value){
                    count++;
                }
            }

            if(node.index*2<=100000 && !visited[node.index*2]){
                queue.add(new Node(node.index*2, node.value+1));
            }

            if(node.index+1<=100000 && !visited[node.index+1]){
                queue.add(new Node(node.index+1, node.value+1));
            }

            if(node.index-1 >= 0 && !visited[node.index-1]){
                queue.add(new Node(node.index-1, node.value+1));
            }
        }

        System.out.println(min);
        System.out.println(count);
    }

    private static class Node{
        int index;
        int value;
        public Node(int i,int v){
            this.index=i;
            this.value=v;
        }
    }

}