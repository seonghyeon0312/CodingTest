import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Number> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(bf.readLine());

            if (command == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(queue.poll().value).append('\n');
                }
            } else {
                queue.add(new Number(command));
            }
        }

        System.out.print(sb);
    }

    static class Number implements Comparable<Number> {
        int value;
        int absValue;

        Number(int value) {
            this.value = value;
            this.absValue = Math.abs(value);
        }

        @Override
        public int compareTo(Number o) {
            if (this.absValue == o.absValue) {
                return Integer.compare(this.value, o.value);
            }
            return Integer.compare(this.absValue, o.absValue);
        }
    }
}