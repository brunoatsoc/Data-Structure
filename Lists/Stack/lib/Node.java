package lib;

//classe Node
public class Node<T>{
    //Atributos da classe Node
    public T data; //Objeto generico que o nó armazena
    public Node<T> next; //Nó para o proximo objeto
    public Node<T> prev; //Nó para o ojeto anterior

    //Construtor que recebe um dado generico
    Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }//fim
}//Fim classe Node