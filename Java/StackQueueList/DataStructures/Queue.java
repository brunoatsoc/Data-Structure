//Pacote em que a classe está
package DataStructures;

//Classe Queue genérica que herada da lista encadeada também generica
public class Queue<T extends Comparable<T>> extends List<T>{
    //Construtor
    public Queue(T data){
        setRearList(data);
    }//Fim

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