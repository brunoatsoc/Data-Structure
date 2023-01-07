import java.util.Arrays;

public class Q7{
    public static void main(String[] args){
        int[] var  = {6, 12, 5, 0, 2, 14, 10, 8};
    
        heapfy(var, var.length, 1);

        System.out.println(Arrays.toString(var));
    }

    public static void heapfy(int[] arr, int size, int type){
        if(type == 1){
            for(int i = size / 2 - 1; i >= 0; i--){
                heapfyMax(arr, size, i);
            }
        }else{
            for(int i = size / 2 - 1; i >= 0; i--){
                heapfyMin(arr, size, i);
            }
        }
    }

    public static void heapfyMax(int[] arr, int size, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if (l < size && arr[l] > arr[largest])
            largest = l;

        if (r < size && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapfyMax(arr, size, largest);
        }
    }

    public static void heapfyMin(int[] arr, int size, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if (l < size && arr[l] < arr[largest])
            largest = l;

        if (r < size && arr[r] < arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapfyMin(arr, size, largest);
        }
    }
}