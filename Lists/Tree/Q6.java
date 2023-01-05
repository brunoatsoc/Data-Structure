import lib.*;

public class Q6{
    public static void main(String[] args){
        Tree<Integer> t = new Tree<Integer>();
        Integer i;

        i = 3;
        t.insertTree(i);

        i = 10;
        t.insertL(i);

        i = 12;
        t.insertR(i);

        System.out.println(t.isHeap());
    }
}