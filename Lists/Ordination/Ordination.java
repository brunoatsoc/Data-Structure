public class Ordination{
    public void mergeSort(Person[] arr, int c){
        int l = arr.length;

        if(l <= 1){
            return;
        }

        int m = l / 2;
        Person[] lArr = new Person[m];
        Person[] rArr = new Person[l - m];
        int i = 0;
        int j = 0;

        for(; i < l; i++){
            if(i < m){
                lArr[i] = arr[i];
            }else{
                rArr[j] = arr[i];
                j++;
            }
        }

        mergeSort(lArr, c);
        mergeSort(rArr, c);
        merge(lArr, rArr, arr, c);
    }

    private void merge(Person[] lArr, Person[] rArr, Person[] arr, int c){
        int lSize = arr.length / 2;
        int rSize = arr.length - lSize;
        int i = 0, l = 0, r = 0;

        while(l < lSize && r < rSize){
            if(c == 1){
                if(lArr[l].getMatricula() < rArr[r].getMatricula()){
                    arr[i] = lArr[l];
                    i++;
                    l++;
                }else{
                    arr[i] = rArr[r];
                    i++;
                    r++;
                }
            }else if(c == 2){
                if(lArr[l].getNome().compareTo(rArr[r].getNome()) < 0){
                    arr[i] = lArr[l];
                    i++;
                    l++;
                }else{
                    arr[i] = rArr[r];
                    i++;
                    r++;
                }
            }else if(c == 3){
                if(lArr[l].getNota() < rArr[r].getNota()){
                    arr[i] = lArr[l];
                    i++;
                    l++;
                }else{
                    arr[i] = rArr[r];
                    i++;
                    r++;
                }
            }
        }

        while(l < lSize){
            arr[i] = lArr[l];
            i++;
            l++;
        }

        while(r < rSize){
            arr[i] = rArr[r];
            i++;
            r++;
        }
    }

//=====================================================================================================

    private int partition(Person[] p, int first, int last, int c){
        Person pivor = p[last];
        int i = first - 1;

        for(int j = first; j < last; j++){
            if(c == 1){
                if(p[j].getMatricula() <= pivor.getMatricula()){
                    i++;
                    Person temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }else if(c == 2){
                if(p[j].getNome().compareTo(pivor.getNome()) <= 0){
                    i++;
                    Person temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }else if(c == 3){
                if(p[j].getNota() <= pivor.getNota()){
                    i++;
                    Person temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
        Person temp = p[i + 1];
        p[i + 1] = p[last];
        p[last] = temp;

        return i + 1;
    }//Fim partition

    public void quickSort(Person[] p, int first, int last, int c){
        if(first < last){
            int pi = partition(p, first, last, c);
            quickSort(p, first, pi - 1, c);
            quickSort(p, pi + 1, last, c);
        }
    }

//================================================================================================

    public void heapsort(Person[] arr, int c){
        int size = arr.length;
 
        for(int i = size / 2 - 1; i >= 0; i--){
            heapify(arr, size, i, c);
        }
 
        for(int i = size - 1; i > 0; i--){
            Person temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0, c);
        }
    }
 

    private void heapify(Person[] arr, int size, int i, int c){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if(c == 1){
            if(l < size && arr[l].getMatricula() > arr[largest].getMatricula()){
                largest = l;
            }
    
            if(r < size && arr[r].getMatricula() > arr[largest].getMatricula()){
                largest = r;
            }
        }else if(c == 2){
            if(l < size && arr[l].getNome().compareTo(arr[largest].getNome()) > 0){
                largest = l;
            }
    
            if(r < size && arr[l].getNome().compareTo(arr[largest].getNome()) > 0){
                largest = r;
            }
        }else if(c == 3){
            if(l < size && arr[l].getNota() > arr[largest].getNota()){
                largest = l;
            }
    
            if(r < size && arr[r].getNota() > arr[largest].getNota()){
                largest = r;
            }
        }
 
        if (largest != i){
            Person swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, size, largest, c);
        }
    }

//=============================================================================================

    public void insertionSort(Person[] arr, int c){
        int size = arr.length;

        for (int i = 1; i < size; i++){
            Person temp = arr[i];
            int j = i - 1;
 
            if(c == 1){
                while(j >= 0 && arr[j].getMatricula() > temp.getMatricula()){
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            }else if(c == 2){
                while(j >= 0 && arr[j].getNome().compareTo(temp.getNome()) > 0){
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            }else if(c == 3){
                while(j >= 0 && arr[j].getNota() > temp.getNota()){
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
            }

            arr[j + 1] = temp;
        }
    }

//===================================================================================

    void selectionSort(Person[] arr, int c){
        int size = arr.length;
 
        if(c == 1){
            for(int i = 0; i < size - 1; i++){
                int min = i;

                for(int j = i + 1; j < size; j++){
                    if(arr[j].getMatricula() < arr[min].getMatricula()){
                        min = j;
                    }
                }
    
                Person temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }else if(c == 2){
            for(int i = 0; i < size - 1; i++){
                int min = i;

                for(int j = i + 1; j < size; j++){
                    if(arr[j].getNome().compareTo(arr[min].getNome()) < 0){
                        min = j;
                    }
                }
    
                Person temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }else if(c == 3){
            for(int i = 0; i < size - 1; i++){
                int min = i;

                for(int j = i + 1; j < size; j++){
                    if(arr[j].getNota() < arr[min].getNota()){
                        min = j;
                    }
                }
    
                Person temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}