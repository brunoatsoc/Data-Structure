//Pacote em que a classe está
package DataStructures;

//Classe Stack que aceita um objeto generico
public class Stack<T extends Comparable<T>> extends List<T>{
    //Construtor
    public Stack(T d){
        setRearList(d);
    }//Fim

    //Metodo push que coloca um objeto na pilha
    public void push(T data){
        setRearList(data);
    }//Fim push

    //Metodo pop que remove um objeto da pilha
    public T pop(){
        if(getSizeList() == 0){
            System.out.printf("Error in pop method, stack is empty!!!\n\n");
            System.exit(-1);
        }
        return removeRear();
    }//Fim pop

    //Metodo stackTop que retorna o objeto que está no topo da pilha
    public T stackTop(){
        if(getSizeList() == 0){
            System.out.printf("Error in stackTop method, stack is empty!!!\n\n");
            System.exit(-1);
        }
        T temp = removeRear();
        setRearList(temp);
        return temp;
    }//Fim pop
}