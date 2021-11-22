package linkedLists;

public class Implementation {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(5);
//        list.insertFirst(83);
//        list.insertFirst(32);
//        list.insertLast(65);
//        list.insert(100,2);
//        list.delete(2);
//        list.display();

//        DLL list = new DLL();
        CLL list = new CLL();

        list.insert(3);
        list.insert(5);
        list.insert(83);
        list.insert(32);
        list.delete(5);
        list.display();

    }
}
