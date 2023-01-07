package lib;

//Classe para a arvore binária
public class Tree<T extends Comparable<T>>{
    //Atributos da classe
    private NodeTree<T> root;
    private int size;

    //Construtor
    public Tree(){
        root = null;
    }//Fim

    //construtor com parametro
    public Tree(T data){
        insertTree(data);
    }//Fim

    //Pega o tamanho da arvore
    public int getSizeTree(){
        return this.size;
    }//Fim getSizeTree

    //Cria nó da arvore
    private NodeTree<T> createNode(NodeTree<T> node, T i){
        node.data = i;
        node.father = null;
        node.left = null;
        node.right = null;
        ++size;
        return node;
    }//Fim createNode

    //Insere um objeto na arvore
    public void insertTree(T i){
        if(root == null){
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            root = newNode;
        }else{
            if(i.compareTo(root.data) == -1){
                insertLeft(root, i);
            }else if(i.compareTo(root.data) == 1){
                insertRight(root, i);
            }
        }
    }//Fim insrtTree

    //Insere a esquerda
    private void insertLeft(NodeTree<T> node, T i){
        if(node.left == null){
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.left = newNode;
            newNode.father = node;
            return;
        }else{
            if(i.compareTo(node.left.data) <= 0){
                insertLeft(node.left, i);
            }else if(i.compareTo(node.left.data) == 1){
                insertRight(node.left, i);
            }
        }
    }//Fim insertLeft

    //Insere a direita da arvore
    private void insertRight(NodeTree<T> node, T i){
        if(node.right == null){
            NodeTree<T> newNode = new NodeTree<T>();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.right = newNode;
            newNode.father = node;
            return;
        }else{
            if(i.compareTo(node.right.data) >= 0){
                insertRight(node.right, i);
            }else if(i.compareTo(node.right.data) == -1){
                insertLeft(node.right, i);
            }
        }
    }//Fim insertRight

    //Imprime a arvore
    public void printTreeAll(){
        printTree(root);
    }//Fim printTreeAll

    //Imprime os nós da arvore em ordem
    private void printTree(NodeTree<T> root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.data.toString());
            printTree(root.right);
        }
    }//Fim printTree

    //Calcula a altura de uma arvore
    public int heightTree(){
        return this.heightTree(root);
    }

    private int heightTree(NodeTree<T> root){
        if(root == null){
            return 0;
        }else{
            int l = heightTree(root.left);
            int r = heightTree(root.right);

            if(l > r){
                return l + 1;
            }else{
                return r + 1;
            }
        }
    }//Fim heightTree

    //Retorna verdadeiro se é completa
    private boolean isComplete(NodeTree<T> root, int index, int nNodes){
        if (root == null){
            return true;
        }
 
        if (index >= nNodes){
            return false;
        }
 
        return isComplete(root.left, (2 * index) + 1, nNodes) && isComplete(root.right, (2 * index) + 2, nNodes);
    }//Fim isComplete

    //Verifica se é um MaxHeap
    private boolean isMaxHeap(NodeTree<T> root){
        if (root.left == null && root.right == null){
            return true;
        }
 
        if (root.right == null) {
            return root.data.compareTo(root.left.data) == 1;
        }else{
            if (root.data.compareTo(root.left.data) == 1 && root.data.compareTo(root.right.data) == 1){
                return isMaxHeap(root.left) && isMaxHeap(root.right);
            }else{
                return false;
            }
        }
    }//Fim isMaxHeap

    //Verifica se é um MinHeap
    private boolean isMinHeap(NodeTree<T> root){
        if (root.left == null && root.right == null){
            return true;
        }
 
        if (root.right == null) {
            return root.data.compareTo(root.left.data) == 1;
        }else{
            if (root.data.compareTo(root.left.data) == -1 && root.data.compareTo(root.right.data) == -1){
                return isMinHeap(root.left) && isMinHeap(root.right);
            }else{
                return false;
            }
        }
    }//Fim isMinHeap

    //Verifica se é um heap
    public int isHeap(NodeTree<T> root){
        if (root == null){
            return 1;
        }
 
        int nodeCounter = this.size;
 
        if (isComplete(root, 0, nodeCounter) == true && isMaxHeap(root) == true){
            return 1;
        }else if(isComplete(root, 0, nodeCounter) == true && isMinHeap(root) == true){
            return -1;
        }

        return 0;
    }

    public int isHeap(){
        return this.isHeap(this.root);
    }//Fim isHeap

    //Fiz esses dois metodos para testar o código
    //Insere um nó a esquerda da raiz
    public void insertL(T i){
        insertLeft(root, i);
    }//Fim insertL

    //Insere um nó a direita da raiz
    public void insertR(T i){
        insertRight(root, i);
    }//Fim insertR
}//Fim classe Tree