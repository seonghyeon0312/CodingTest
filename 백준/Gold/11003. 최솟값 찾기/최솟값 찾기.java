import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        Deque<Node> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }

            deque.addLast(new Node(now, i));
            if(deque.getFirst().idx <= i-l){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        int value;
        int idx;

        Node(int val, int idx){
            this.value= val;
            this.idx= idx;
        }
    }
}
