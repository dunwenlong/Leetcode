package huawei;

import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/18 21:24
 */
public class FindFinalSpot {
    public static int[] countADWS = new int[4];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] spots = str.split(";");
            for (String s : spots) {
                isSpot(s);
            }
            StringBuilder stb = new StringBuilder();
            stb.append(countADWS[1]-countADWS[0]);
            stb.append(',');
            stb.append(countADWS[2]-countADWS[3]);
            System.out.println(stb.toString());
        }
    }

    private static boolean isSpot(String s) {
        if(s==null || s.length()<1 || s.length()>3){
            return false;
        }
        int indexC = isADWS(s.charAt(0));
        if(indexC>-1 && indexC<4 && isNum(s.substring(1, s.length()))){
            countADWS[indexC] += Integer.valueOf(s.substring(1, s.length()));
            return true;
        } else{
            return false;
        }
    }

    private static int isADWS(char c) {
        switch(c){
            case 'A':
                return 0;
            case 'D':
                return 1;
            case 'W':
                return 2;
            case 'S':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean isNum(String s) {
        if(s==null || s.length()<1){
            return false;
        }
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
