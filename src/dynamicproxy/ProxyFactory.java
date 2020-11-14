package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Dun Wenlong
 * @time 2020/9/15 21:31
 */
//public class ProxyFactory {
//    public static <T> getProxy(T target){
//        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new LogHandler(target));
//    }
//
//    private static class LogHandler implements InvocationHandler {
//        private T target;
//        public <T>LogHandler(T target) {
//            this.target = (T)target;
//        }
//    }
//}
