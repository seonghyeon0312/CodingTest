import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main{
    static boolean isWord = true;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();


//        List<String> strings = Arrays.stream(s.split("")).toList();

        List<String> strings = Arrays.stream(s.split(""))
                .collect(Collectors.toList());
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for(String word : strings){
            if(word.equals("<") || word.equals(" ")){
                while(!stack.isEmpty()){
                    result.add(stack.pop());
                }
                result.add(word);
                if(word.equals("<"))
                    isWord = false;
                continue;
            }else if(word.equals(">")){
                isWord = true;
                result.add(word);
                continue;
            }
            if(isWord){
                stack.add(word);
            }else{
                result.add(word);
            }
        }

        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                result.add(stack.pop());
            }
        }

        StringJoiner sj = new StringJoiner("");

        for(String word : result){
            sj.add(word);
        }

        System.out.println(sj);


    }
}