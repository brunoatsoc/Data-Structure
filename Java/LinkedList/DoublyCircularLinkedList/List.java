public class List{
    //Atributos
    private int size;
    private Node head;
    private Node tail;

    //Construtor com parametro
    public List(Person p){
        insertFront(p);
    }

    //Construtor sem parametros
    public List(){
        this.size = 0;
        this.head = null;
    }

    //Seta um objeto na frente da lista
    public void setFront(int age, String nome){
        Person p = new Person(age, nome);
        insertFront(p);
    }

    //Seta um objeto no final da lista
    public void setRear(int age, String nome){
        Person p = new Person(age, nome);
        insertRear(p);
    }

    //Seta um objeto em uma posição especifica da lista
    public void setInPosition(int age, String nome, int position){
        Person p = new Person(age, nome);
        insertInPosition(p, position);
    }

    //Cria nó da lista
    private static Node createNode(Node node, Person i){
        node.data = i;
        node.next = null;
        node.prev = null;

        return node;
    }

    //Insere um objeto na frente da lista
    public void insertFront(Person i){
        Node newNode = new Node();
        newNode = createNode(newNode, i);

        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        }

        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        tail.next = newNode;
        head = newNode;
        ++size;
    }

    //Insere um objeto no final da lista
    public void insertRear(Person i){
        Node newNode = new Node();
        newNode = createNode(newNode, i);

        if(head == null){
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        }

        newNode.prev = tail;
        newNode.next = head;
        tail.next = newNode;
        head.prev = newNode;
        tail = newNode;
        ++size;
    }

    //Insere um objeto em uma posição especifica da lista
    public void insertInPosition(Person i, int position){
        if((position > size) || (position < 1)){
            System.out.printf("Error in insertInPosition, invalid position!!\n");
            System.exit(-1);
        }

        if(position == 1){
            insertFront(i);
            return;
        }else if(position == size){
            insertRear(i);
            return;
        }else{
            Node newNode = new Node();
            newNode = createNode(newNode, i);
            Node aux = head;
            int count;

            for(count = 1; count < position - 1; count++){
                aux = aux.next;
            }

            newNode.next = aux.next;
            newNode.prev = aux;
            aux.next.prev = newNode;
            aux.next = newNode;
            ++(size);
        }
    }

    //Remove um objeto da frente da lista
    public Person removeFront(){
        if(head == null){
            System.out.printf("Error in removefront, list is empty\n");
            System.exit(-1);
        }

        Person temp = head.data;

        if(head == tail){
            size = 0;
            head = null;
            tail = null;
            return temp;
        }else{
            Node aux = head;

            head = aux.next;
            head.prev = tail;
            tail.next = head;
            aux = null;
            --size;
            return temp;
        }
    }

    //Remove um objeto do final da lista
    public Person removeRear(){
        if(head == null){
            System.out.println("Error in removeRear, list is empty!!");
            System.exit(-1);
        }

        Person temp = tail.data;

        if(head == tail){
            size = 0;
            head = null;
            tail = null;
            return temp;
        }else{
            Node aux = tail;

            tail = aux.prev;
            tail.next = head;
            head.prev = tail;
            aux = null;
            return temp;
        }
    }

    //Remove um objeto em uma posição especifica da lista
    public Person removeInPosition(int position){
        if(head == null){
            System.out.printf("Error in removeInPosition, list is empty!!\n");
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
            Node aux = head;
            int count;

            for(count = 1; count < position; count++){
                aux = aux.next;
            }
            Person auxItem = aux.data;

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            aux = null;
            --size;
            return auxItem;
        }
    }

    //Imprime a Lista
    public void printList(){
        if(head == null){
            System.out.println("Error in prinList, list is empty!!");
            System.exit(-1);
        }
        printNode(head, head);
    }

    //Imprime um nó da lista
    private void printNode(Node node, Node lastNode){
        if(node.next == lastNode){
            System.out.println(node.data.toString());
            return;
        }
        System.out.println(node.data.toString());
        printNode(node.next, lastNode);
    }
}