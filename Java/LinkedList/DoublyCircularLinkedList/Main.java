public class Main{
    public static void main(String[] args){
       List<Person> l = new List<Person>();
       String[] s = {"Bruno", "Flavia", "Coito", "Kakau", "Valter", "Arthur", "Gustavo", "Brenda", "Henio", "Dan"};
        String s1, s2;

        for(int i = 0; i < 10; i++){
            Person p = new Person(i, s[i]);
            l.setFrontList(p);
        }
        //l.removeFront();
        //l.removeFront();
        //l.removeRear();
        Person a = new Person(1, "Flavia");
        l.removeItem(a);
        l.printList();
    }
}