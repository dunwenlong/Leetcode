package voicenet;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/9/28 19:28
 */
public class FirstChar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(getResult(input));
        }
    }

    private static char getResult(String input) {
        char[] cs = input.toCharArray();
        LinkedHashMap<Character, Integer> wordsMap = new LinkedHashMap<>();
        for(int i = 0; i < cs.length; i++){
            wordsMap.put(cs[i], wordsMap.getOrDefault(cs[i], 0)+1);
        }
        char res = ' ';
        for(Map.Entry entry: wordsMap.entrySet()){
            if(entry.getValue().equals(1)){
                res = (char) entry.getKey();
                break;
            }
        }
        return res;
    }
}
