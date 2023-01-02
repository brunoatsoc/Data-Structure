import lib.*;

public class Q4{
    public static void main(String[] args){
        Integer n = 3960;
        Queue<Integer> q = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();

        for(int i = 2; n != 1 ;){
            if(isPrime(i) && ((n % i) == 0)){
                n = n / i;
                q.enqueue(i);
            }else{
                ++i;
            }
        }

        int size = q.qSize();
        int size1 = q.qSize();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j == size1 - 1){
                    q2.enqueue(q.qFront());
                    size1--;
                }
                q.enqueue(q.dequeue());
            }
        }

        while(!q2.isEmpty()){
            System.out.println(q2.dequeue());
        }
    }

    public static boolean isPrime(int n){
        if(n == 2 || n == 3){
            return true;
        }else if((n % 2) == 0){
            return false;
        }else{
            for(int i = 3; i < n; i++){
                if(n % i == 0){
                    return false;
                }
            }

            return true;
        }
    }
}