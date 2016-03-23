import java.util.*;

public class testPriorityQueue {
    public static void main(String[] args) {
        Set<Integer> list = new HashSet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        Iterator<Integer> integerIterator2 = list.iterator();
        while (integerIterator2.hasNext()) {
            System.out.println(integerIterator2.next());
        }
    }
}
