//Pacote em que a classe está
package lib;

//Classe Queue genérica que herada da lista encadeada também generica
public class Queue<T extends Comparable<T>> extends List<T>{
    //Retorna true se a fila está vazia
    public boolean isEmpty(){
        if(getSizeList() == 0){
            return true;
        }else{
            return false;
        }
    }//Fim isEmpty

    //Retorna o primero da fila
    public T qFront(){
        T temp = removeFront();

        setFrontList(temp);

        return temp;
    }//Fim qFront

    //Mostra o tamanho da fila
    public int qSize(){
        return getSizeList();
    }
    //Fim qSize

    //Metodo enqueue que coloca um objeto no final da fila
    public void enqueue(T data){
        setRearList(data);
    }//Fim enqueue

    //Metodo dequeue que remove um objeto do começo da fila
    public T dequeue(){
        if(getSizeList() == 0){
            System.out.println("Error in dequeue method, queue is empty!!\n\n");
            System.exit(-1);
        }

        return removeFront();
    }//Fim dequeue
}//Fim classe Queue