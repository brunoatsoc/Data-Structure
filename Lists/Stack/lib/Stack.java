//Pacote em que a classe está
package lib;

//Classe Stack que aceita um objeto generico
public class Stack<T extends Comparable<T>> extends List<T>{
    //Metodo push que coloca um objeto na pilha
    public void push(T data){
        setRearList(data);
    }//Fim push

    //Retorna verdadeiro se a pilha estiver vazia
    public boolean isEmpty(){
        if(getSizeList() == 0){
            return true;
        }else{
            return false;
        }
    }//Fim isEmpty

    //Metodo pop que remove um objeto da pilha
    public T pop(){
        if(getSizeList() == 0){
            System.out.printf("Error in pop method, stack is empty!!!\n\n");
            System.exit(-1);
        }
        T v = removeRear();
        return v;
    }//Fim pop

    //Metodo stackTop que retorna o objeto que está no topo da pilha
    public T stackTop(){
        if(getSizeList() == 0){
            System.out.printf("Error in stackTop method, stack is empty!!!\n\n");
            System.exit(-1);
        }
        T temp = pop();
        setRearList(temp);
        return temp;
    }//Fim pop
}//Fim classe Stack