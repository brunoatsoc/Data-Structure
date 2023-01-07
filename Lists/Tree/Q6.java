import lib.*;

public class Q6{
    public static void main(String[] args){
        Tree<Integer> t = new Tree<Integer>();
        Integer i;

        i = 10;
        t.insertTree(i);

        i = 15;
        t.insertTree(i);

        i = 10;
        t.insertTree(i);

        i = 6;
        t.insertTree(i);

        i = 10;
        t.insertTree(i);

        i = 7;
        t.insertTree(i);

        System.out.println(t.isHeap());
    }
}