import java.util.LinkedList;

public class TwoLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);

        if(list1 == list2) {
            System.out.println("Both linked lists are the same.");
        } else {
            System.out.println("The linked lists are different.");
        }

    }
}
