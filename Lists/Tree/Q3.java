import lib.*;

public class Q3{
    /*
     * A função está no arquivo Tree.java
     *
     */
    public static void main(String[] args){
        Tree<Integer> t = new Tree<Integer>();
        Integer i;

        i = 17;
        t.insertTree(i);

        i = 10;
        t.insertTree(i);

        i = 15;
        t.insertTree(i);

        i = 10;
        t.insertTree(i);

        //t.printTreeAll();

        System.out.println(t.heightTree());
    }
}