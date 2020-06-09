import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> data;
    LinkedList<Integer> minData;
    public MinStack(){
        data = new LinkedList<>();
        minData = new LinkedList<>();
    }
    public void push(int x){
        data.addLast(x);
        LinkedList<Integer> help = new LinkedList<>();
        if(minData.isEmpty()){
            minData.addLast(x);
        } else{
            //可以优化
            while (!minData.isEmpty()&&x>minData.getLast()){
                help.addLast(minData.removeLast());
            }
            minData.addLast(x);
            while (!help.isEmpty()){
                minData.addLast(help.removeLast());
            }
        }
    }
    public void pop(){
        if(data.isEmpty()){
            return;
        } else if(data.getLast().equals(minData.getLast())){
            minData.removeLast();
        }
        data.removeLast();
    }
    public int top(){
        return data.getLast();
    }
    public int min(){
        return minData.getLast();
    }
}
