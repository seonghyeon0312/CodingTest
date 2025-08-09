import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder out = new StringBuilder(s.length());
        Deque<Character> stack = new ArrayDeque<>(); // faster than legacy Stack
        boolean inTag = false; // true면 <tag> 내부, false면 바깥(단어 뒤집기 구간)

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {          // 태그 시작 → 그 전에 쌓인 단어 뒤집어서 출력
                flush(stack, out);
                inTag = true;
                out.append(ch);
            } else if (ch == '>') {   // 태그 종료
                inTag = false;
                out.append(ch);
            } else if (inTag) {       // 태그 내부는 그대로 출력
                out.append(ch);
            } else if (ch == ' ') {   // 단어 경계 → 지금까지의 단어 뒤집고 공백 출력
                flush(stack, out);
                out.append(' ');
            } else {                  // 태그 밖의 문자 → 스택에 쌓았다가 뒤집어 출력
                stack.push(ch);
            }
        }

        // 마지막 단어가 남아 있다면 비워서 출력
        flush(stack, out);

        System.out.println(out.toString());
    }

    private static void flush(Deque<Character> stack, StringBuilder out) {
        while (!stack.isEmpty()) {
            out.append(stack.pop());
        }
    }
}