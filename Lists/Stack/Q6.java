import java.util.Scanner;
import lib.*;

public class Q6{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String ES;
        int[] placa = new int[10];
        int p;
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> s1 = new Stack<Integer>();

        for(int i = 0; i < 10;){
            System.out.printf("Entrada ou Saida[E/S]: ");
            ES = input.nextLine();
            
            if(ES.equals("E")){
                System.out.printf("Digite a placa do carro: ");
                placa[i] = input.nextInt();
                input.nextLine();
                ++i;
            }else{
                System.out.printf("Digite a placa do carro que vai sair: ");
                p = input.nextInt();
                input.nextLine();

                for(int j = 0; j < i; j++){
                    Integer var;

                    if(placa[j] != p){
                        var = placa[j];
                        s.push(var);
                    }else{
                        placa[j] = -1;
                        var = placa[j];
                        s.push(var);
                    }
                }

                for(int j = 0; j < i; j++){
                    s1.push(s.pop());
                }

                for(int j = 0; j < i; j++){
                    placa[j] = s1.pop();
                }

                for(int j = 0; j < i; j++){
                    System.out.println(placa[j]);
                }
            }
        }
    }
}