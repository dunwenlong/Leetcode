/**
 * @author Dun Wenlong
 * @date 2020/6/13
 */
public class Person {
    private String name;
    private String getName(){
        return this.name;
    }

    class Student extends Person{
        public void printName(){
            System.out.println(getName());
        }
    }
}
