import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int test_case=1;test_case<=10;test_case++){
            int cnt=0;
            Stack<String> stack=new Stack<>();
            String[][] board=new String[8][];
            st=new StringTokenizer(bf.readLine());
            int len=Integer.parseInt(st.nextToken());
            for(int i=0;i<8;i++){
                st=new StringTokenizer(bf.readLine());
                board[i]=st.nextToken().split("");
            }
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    stack.add(board[i][j]);
                    if(stack.size()==len){
                        Stack<String> reversed=new Stack<>();
                        reversed.addAll(stack);
                        Collections.reverse(reversed);
                        if(stack.toString().equals(reversed.toString())){
                            cnt++;
                        }
                        stack.remove(0);
                    }
                }
                stack.clear();
            }
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    stack.add(board[j][i]);
                    if(stack.size()==len){
                        Stack<String> reversed=new Stack<>();
                        reversed.addAll(stack);
                        Collections.reverse(reversed);
                        if(stack.toString().equals(reversed.toString())){
                            cnt++;
                        }
                        stack.remove(0);
                    }
                }
                stack.clear();
            }
            System.out.println("#"+test_case+" "+cnt);
        }
    }

}