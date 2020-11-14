package dynamicproxy;

/**
 * @author Dun Wenlong
 * @time 2020/9/15 21:30
 */
public class RealModule implements HttpApi{
    @Override
    public String get(String url) {
        return "result";
    }
}
