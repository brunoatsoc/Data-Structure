import lib.*;

public class Q3{
    /*
     * A função está no arquivo Tree.java
     * É a ultima função
     */
    public static void main(String[] args){
        Tree<Integer> t = new Tree<Integer>();
        Integer i;

        i = 10;
        t.insertTree(i);

        i = 43;
        t.insertTree(i);

        i = 12;
        t.insertTree(i);

        i = 100;
        t.insertTree(i);

        t.printTreeAll();

        System.out.println(t.heightOfTree());
    }
}