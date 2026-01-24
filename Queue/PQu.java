import java.util.*;

public class PQu {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println(pq.poll()); // 30
        System.out.println(pq.poll()); // 20
        System.out.println(pq.poll()); // 10

    }
}
