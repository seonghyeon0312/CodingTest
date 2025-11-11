import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alphabets = sc.next().split("");

        Map<String, Integer> counts = new HashMap<>();

        for(String alphabet : alphabets){
            String lowerAlphabet = alphabet.toLowerCase();
            counts.put(lowerAlphabet, counts.getOrDefault(lowerAlphabet, 0)+1);
        }

        Integer max = Collections.max(counts.values());
        int maxAlphabetCount = 0;
        String resultAlphabet = "";
        for(Map.Entry<String, Integer> entry : counts.entrySet()){
            if(entry.getValue().equals(max)){
                maxAlphabetCount++;
                resultAlphabet = entry.getKey();
            }
        }

        if(maxAlphabetCount > 1){
            System.out.println("?");
        }else{
            System.out.println(resultAlphabet.toUpperCase(Locale.ROOT));
        }
    }
}