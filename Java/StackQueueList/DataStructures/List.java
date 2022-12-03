//Pacote em que a classe está
package DataStructures;

//Classe generica para uma lista encadeada
public class List<T extends Comparable<T>>{
    //classe Node
    private static class Node<T>{
        //Atributos da classe Node
        T data; //Objeto generico que o nó armazena
        Node<T> next; //Nó para o proximo objeto
        Node<T> prev; //Nó para o ojeto anterior

        //Construtor que recebe um dado generico
        Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }//fim
    }//Fim classe Node

    //Atributos da classe List
    private int size = 0; //Guarda o tamanho da lista
    private Node<T> head; //Primeiro item da lista
    private Node<T> tail; //Primero item da lista

    //Construtor
    public List(){
        this.head = null;
        this.tail = null;
    }//Fim

    //Metodo getSizeList para obter o tamanho da lista
    public int getSizeList(){
        return this.size;
    }//Fim getSizeList

    //Função para setar um item no começo da lista
    public void setFrontList(T data){
        T d = data;
        d = data;
        insertFront(d);
    }//Fim setFrontList

    //Função para setar um item no final da lista
    public void setRearList(T data){
        T d = data;
        insertRear(d);
    }//Fim setRearList

    //Função para setar um item em alguma posição da lista
    public void setInPositionList(T data, int position){
        T d = data;
        insertInPosition(d, position);
    }//Fim setInPositionList

    //Insere um item no começo da lista
    private void insertFront(T data){
        Node<T> newNode = new Node<T>(data);

        if(this.head == null){ //Para o caso da lista estar vazia
            head = newNode;
            tail = newNode;
            ++size;
        }else{ //Para o caso de ter algum item na lista
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
            ++size;
        }
    }//Fim isert front

    //insere um item no final da lista
    private void insertRear(T data){
        Node<T> newNode = new Node<T>(data);

        if(this.head == null){ //Para o caso da lista estar vazia
            head = newNode;
            tail = newNode;
            ++size;
        }else{ //Para o caso de ter algum item na lista
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
            ++size;
        }
    }//Fim insertRear

    //Insere um item uma posição especifica
    private void insertInPosition(T data, int position){
        if((position > this.size) || (position < 1)){
            System.out.printf("Error in insertInPosition, invalid position!!\n\n");
            System.exit(-1);
        }

        if(position == 1){
            insertFront(data);
            return;
        }else if(position == size){
            insertRear(data);
            return;
        }else{
            Node<T> newNode = new Node<T>(data);
            Node<T> aux = head;
            int count;

            for(count = 1; count < (position - 1); count++){
                aux = aux.next;
            }

            newNode.next = aux.next;
            newNode.prev = aux;
            aux.next.prev = newNode;
            aux.next = newNode;
            ++size;
        }
    }//Fim insertInPosition

    //Remove um item da frente da lista
    public T removeFront(){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        T temp = head.data;

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return temp;
        }else{
            Node<T> aux = head;

            head = aux.next;
            head.prev = tail;
            tail.next = head;
            aux = null;
            --size;
            return temp;
        }
    }//Fim removeFront

    //Remove um item do final da lista
    public T removeRear(){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        T temp = tail.data;

        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return temp;
        }else{
            Node<T> aux = tail;

            tail = aux.prev;
            tail.next = head;
            head.prev = tail;
            aux = null;
            --size;
            return temp;
        }
    }//Fim removeRear

    //Remove um item em uma posição especifica na lista
    public T removeInPosition(int position){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        if((position > size) || (position < 1)){
            System.out.printf("Error is removeInPosition, ivalid position!!\n");
            System.exit(-1);
        }

        if(position == 1){
            return removeFront();
        }else if(position == size){
            return removeRear();
        }else{
            Node<T> aux = head;
            
            for(int i = 1; i < position; i++){
                aux = aux.next;
            }
            T temp = aux.data;

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            aux = null;
            --size;
            return temp;
        }
    }//Fim removeInPosition

    //Imprime a lista
    public void printList(){
        if(head == null){
            System.out.printf("Error in printList, list is empty!!\n\n");
            System.exit(-1);
        }
        printNode(this.head, this.head);
    }//Fim printList

    private void printNode(Node<T> h1, Node<T> h2){
        if(h1.next == h2){
            System.out.println(h1.data.toString());
            return;
        }
        System.out.println(h1.data.toString());
        printNode(h1.next, h2);
    }//Fim printNode

   //Remove um item especifico da lista
    public T removeItem(T d){
        Node<T> item = findNode(head, d);

        if((getSizeList() == 1) || item == head){
            return removeFront();
        }else if(item == tail){
            return removeRear();
        }else{
            T temp = item.data;
            item.prev.next = item.next;
            item.next.prev = item.prev;
            item = null;
            --(this.size);
            return temp;
        }
    }//Fim removeItem

    //Procura um nó na lista
    private Node<T> findNode(Node<T> node, T d){
        if(node.data.compareTo(d) == 0){
            return node;
        }

        if(node == this.tail){
            System.out.println("Data not found!!\n\n");
            System.exit(-1);
        }

        return findNode(node.next, d);
    }//Fim findNode
}//Fim classe List