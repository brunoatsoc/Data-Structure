import java.util.Scanner;
import lib.*;

public class Q6{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String ES;
        Car[] c = new Car[10];
        int p;
        Stack<Car> s = new Stack<Car>();
        Stack<Car> s1 = new Stack<Car>();

        for(int i = 0; i < 10;){
            System.out.printf("Entrada ou Saida[E/S]: ");
            ES = input.nextLine();
            
            if(ES.equals("E")){
                System.out.printf("Digite a placa do carro: ");
                c[i] = new Car();
                c[i].setPlaca(input.nextInt());
                input.nextLine();
                ++i;
            }else{
                System.out.printf("Digite a placa do carro que vai sair: ");
                p = input.nextInt();
                input.nextLine();

                int j;
                int pos = 0;
                for(j = 0; j < i; j++){
                    Car var;

                    if(c[j].getPlaca() != p){
                        if(s.stackSize() > 0){
                            if(c[j].getPlaca() == -1){
                                c[j].setManobra(0);
                            }else{
                                c[j].setManobra(1);
                            }

                            var = c[j];
                            s.push(var);
                        }else{
                            pos++;
                        }
                    }else{
                        Car ca = new Car();
                        ca.setPlaca(-1);
                        c[j] = ca;
                        var = c[j];
                        s.push(var);
                    }
                }

                for(int k = pos + 1; k < j; k++){
                    s1.push(s.pop());
                }
                s.pop();

                for(int k = pos + 1; k < j; k++){
                    c[k] = s1.pop();
                }
                System.out.println(s1.stackSize());

                for(int k = 0; k < i; k++){
                    System.out.println(c[k]);
                }
            }
        }
    }
}