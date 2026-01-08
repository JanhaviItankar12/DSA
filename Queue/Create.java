
import java.util.LinkedList;
import java.util.Queue;

public class Create {
    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<>();

        q.add(10);
        q.add(30);
        q.add(80);
        q.remove();

        System.out.println(q.peek());
    }
}
