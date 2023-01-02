public class HeapMax{
    private int size;
    private int[] arr;

    public HeapMax(int[] var){
        this.size = var.length;
    }

    private int getLeftChild(int n){
        return arr[n * 2];
    }

    private int getRightChild(int n){
        return arr[(2 * n )+ 1];
    }

    public void maxHeapfy(int i){
        int l = 2 * i;
        int r = (2 * i) + 1;

        while(l <= (size - 1) && arr[l] > arr[size]){
            size = l;
        }
    }
}