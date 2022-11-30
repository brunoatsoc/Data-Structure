public class Main{
    public static void main(String[] args){
        List l = new List();
        Person p = new Person(22, "Bruno");

        l.insertRear(p);
        p.setInfo(22, "Klaus");
        l.setRear(p);
        p.setInfo(18, "Kakau");
        l.setRear(p);
        p.setInfo(18, "Coito");
        l.setRear(p);
        p.setInfo(19, "Flávia");
        l.setRear(p);
        p.setInfo(18, "Luiz");
        l.setRear(p);
        p.setInfo(20, "Pedro");
        l.setRear(p);
        p.setInfo(19, "Valter");
        l.setRear(p);

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