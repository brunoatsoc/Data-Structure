public class Main{
    public static void main(String[] args){
        Person p = new Person(22, "Bruno");
        Tree t = new Tree();

        t.setTree(p);
        p.setInfo(19, "Flávia");
        t.setTree(p);
        p.setInfo(32, "Luiz");
        t.setTree(p);
        p.setInfo(20, "Pedro");
        t.setTree(p);
        p.setInfo(27, "Lusca");
        t.setTree(p);

        t.printTreeAll();
    }
}