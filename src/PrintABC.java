import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dun Wenlong
 * @time 2020/9/15 20:36
 */
public class PrintABC {
    private static Lock lock = new ReentrantLock();
    public static int state = 0;
    static class PrintThread extends Thread{
        int num;
        String letter;
        public PrintThread(int num, String letter){
            this.num = num;
            this.letter = letter;
        }

        @Override
        public void run() {
            for(int i=0; i<10; ){
                try{
                    lock.lock();
                    while(state%3 == num){
                        System.out.println(letter);
                        state++;
                        i++;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args){
        PrintThread threadA = new PrintThread(0, "A");
        PrintThread threadB = new PrintThread(1, "B");
        PrintThread threadC = new PrintThread(2, "C");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
