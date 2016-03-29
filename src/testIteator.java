import java.util.*;

/**
 * Created by yuanyuan on 3/23/16.
 */
public class testIteator {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.add(4);
            System.out.println(iterator.next());
//            list.add(4);


        }
        ListIterator iterator2 = list.listIterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
