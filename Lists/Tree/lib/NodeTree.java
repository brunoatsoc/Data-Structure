package lib;

//Classe para os nó da arvore binária
public class NodeTree<T>{
    //Atributos da classe
    T data; //Dado que a arvore recebe
    NodeTree<T> father; //Nó pai
    NodeTree<T> left; //Filho esquerdo
    NodeTree<T> right; //Filho direito

    //Construtor
    public NodeTree(){
        this.data = null;
        this.father = null;
        this.left = null;
        this.right = null;
    }//Fim
}//Fim classe NodeTree