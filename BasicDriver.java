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
        //SHOULD BE 01 but is 12

        System.out.println(dll.size());
        //should be 2

        dll.add(2,3);
        System.out.println(dll.toString());
        //was added to the front instead


        

    }
    

}
