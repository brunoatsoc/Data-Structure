public class Main{
    public static void main(String[] args){
        List l = new List();
        Person p = new Person(22, "Bruno");

        l.insertRear(p);
        l.setRear(15, "Fernanda");
        l.setRear(21, "Ana");
        l.setRear(24, "Fabiana");
        l.setRear(18, "Levi");
        l.setRear(30, "Julia");
        l.setRear(25, "Laura");
        l.setRear(24, "Brisa");
        l.setInPosition(19, "Paula", 7);

        /*l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();
        l.removeFront();*/

        /*l.removeRear();
        l.removeRear();
        l.removeRear();*/

        l.removeInPosition(1);

        l.printList();
    }
}