/**
 * @author Admin
 */
public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        int count = 0;
        int i3 = 0;
        int i5 = 0;
        int i7 = 0;
        int[] num3 = new int[k];
        int[] num5 = new int[k];
        int[] num7 = new int[k];
        int minNum = 1;
        count++;
        for (; count < k; count++) {
            num3[count-1] = minNum*3;
            num5[count-1] = minNum*5;
            num7[count-1] = minNum*7;
            minNum = Math.min(Math.min(num3[i3], num5[i5]),num7[i7]);
            if(num3[i3]==minNum){
                i3++;
            }
            if(num5[i5] == minNum){
                i5++;
            }
            if(num7[i7] == minNum){
                i7++;
            }
        }
        return minNum;
    }
}
