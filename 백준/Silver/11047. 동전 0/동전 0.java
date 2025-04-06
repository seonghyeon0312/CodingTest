import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num<=k){
                arrayList.add(num);
            }
        }

        Collections.reverse(arrayList);
        int mod = k;
        int count = 0;
        for(int num : arrayList) {
            if(mod == 0){
                break;
            }
            if(mod>=num){
                count += (mod / num);
                mod %= num;
            }else{
                continue;
            }
        }

        System.out.println(count);

    }
}