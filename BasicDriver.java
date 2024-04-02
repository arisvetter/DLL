import java.util.ListIterator;

public class BasicDriver {
    
    public static void main(String[] args){
        IUDoubleLinkedList<Integer> dll = new IUDoubleLinkedList<Integer>();
        dll.add(1);
        System.out.println(dll.toString());
        //1

        dll.addToRear(2);
        System.out.println(dll.toString());
        //12

        dll.addToFront(0);
        System.out.println(dll.toString());
        //012

        dll.removeFirst();
        System.out.println(dll.toString());
        //12

        dll.removeLast();
        System.out.println(dll.toString());
        //1

        dll.addToRear(2);
        System.out.println(dll.toString());
        //12

        dll.addToFront(0);
        System.out.println(dll.toString());
        //012

        dll.removeLast();
        System.out.println(dll.toString());
        //01

        System.out.println(dll.size());
        //2

        dll.add(2,3);
        System.out.println(dll.toString());
        //013

        Integer three = new Integer(3);
        dll.remove(three);
        System.out.println(dll.toString());
        //01

        Integer zero = new Integer(0);
        dll.remove(zero);
        System.out.println(dll.toString());
        //1

        Integer one = new Integer(1);
        dll.remove(one);
        System.out.println(dll.toString());
        //

        dll.add(1);
        dll.add(2);
        System.out.println(dll.toString());
        //12

        ListIterator myLI = dll.listIterator();




        

    }
    

}
