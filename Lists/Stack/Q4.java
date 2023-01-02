import java.util.Random;
import lib.*;

public class Q4{
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        Stack<Integer> s4 = new Stack<Integer>();
        Integer[] baralho = new Integer[52];
        Random rd = new Random();

        for(int i = 0; i < 52; i++){
            baralho[i] = i + 1;
        }

        for(int i = 0; i < 52;){
            int r;
            r = rd.nextInt(5) + 1;

            if(r == 1){
                s1.push(baralho[i]);
                ++i;
            }else if(r == 2){
                s2.push(baralho[i]);
                ++i;
            }else if(r == 3){
                s3.push(baralho[i]);
                ++i;
            }else if(r == 4){
                if(!s1.isEmpty()){
                    s2.push(s1.pop());
                    ++i;
                }else{
                }
            }else if(r == 5){
                if(!s2.isEmpty()){
                    s3.push(s2.pop());
                    ++i;
                }else{
                }
            }else if(r == 6){
                if(!s3.isEmpty()){
                    s1.push(s3.pop());
                    ++i;
                }else{
                }
            }
        }

        while(!s1.isEmpty()){
            s4.push(s1.pop());
        }

        while(!s2.isEmpty()){
            s4.push(s2.pop());
        }

        while(!s3.isEmpty()){
            s4.push(s3.pop());
        }

        while(!s4.isEmpty()){
            System.out.println(s4.pop() + "\n");
        }
    }
}