import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Ordination o = new Ordination();
        Person[] p = new Person[5];

        p[0] = new Person(11, "Bruno", 6);
        p[1] = new Person(7, "Flavia", 9.4f);
        p[2] = new Person(19, "Coito", 9);
        p[3] = new Person(12, "Valter", 7);
        p[4] = new Person(9, "Rogerio", 10);

        //o.mergeSort(p, 3);
        //o.quickSort(p, 0, p.length - 1, 3);
        //o.heapsort(p, 3);
        //o.insertionSort(p, 3);
        //o.selectionSort(p, 3);
        System.out.println(Arrays.toString(p));
    }
}