import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> dq=new ArrayDeque<>();

        dq.addFirst(10);
        dq.addFirst(70);
        dq.addFirst(67);
        dq.addFirst(40);
        dq.addFirst(32);

        dq.addLast(78);
        dq.addLast(98);
        dq.addLast(58);
        dq.addLast(48);

        dq.removeFirst();
        dq.removeLast();

        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        System.out.println(dq);

    }
}
