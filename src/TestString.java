/**
 * @author Dun Wenlong
 * @time 2020/6/22 16:30
 */
public class TestString {
    public static void main(String[] args){
        TestString testString = new TestString();
        String str1 = new String("abab");
        String str2 = new String("abab");
        System.out.println(str1.equals(str2));
    }
    private String getString1(){
        String str1 = "abab";
        return str1;
    }
    private String getString2(){
        String str2 = "abab";
        return str2;
    }
}
