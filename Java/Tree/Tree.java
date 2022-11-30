public class Tree{
    private Node root;

    public Tree(){
        root = null;
    }

    public Tree(Person i){
        insertTree(i);
    }

    public Node getRoot(){
        return root;
    }

    public void setTree(Person p){
        Person i = new Person(p.getAge(), p.getName());
        insertTree(i);
    }

    private Node createNode(Node node, Person i){
        node.data = i;
        node.father = null;
        node.left = null;
        node.right = null;
        return node;
    }

    private void insertTree(Person i){
        if(root == null){
            Node newNode = new Node();
            newNode = createNode(newNode, i);
            root = newNode;
        }else{
            if(i.getAge() < root.data.getAge()){
                insertLeft(root, i);
            }else if(i.getAge() > root.data.getAge()){
                insertRight(root, i);
            }
        }
    }

    private void insertLeft(Node node, Person i){
        if(node.left == null){
            Node newNode = new Node();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.left = newNode;
            newNode.father = node;
            return;
        }else{
            if(i.getAge() < node.left.data.getAge()){
                insertLeft(node.left, i);
            }else if(i.getAge() > node.left.data.getAge()){
                insertRight(node.left, i);
            }
        }
    }

    private void insertRight(Node node, Person i){
        if(node.right == null){
            Node newNode = new Node();
            newNode = createNode(newNode, i);
            newNode.data = i;
            node.right = newNode;
            newNode.father = node;
            return;
        }else{
            if(i.getAge() > node.right.data.getAge()){
                insertRight(node.right, i);
            }else if(i.getAge() < node.right.data.getAge()){
                insertLeft(node.right, i);
            }
        }
    }

    public void printTreeAll(){
        printTree(root);
    }

    private void printTree(Node root){
        if(root != null){
            printTree(root.left);
            System.out.println(root.data.toString());
            printTree(root.right);
        }
    }

    //Retorna o conteúdo do nó
    public Person info(Node p){
        return p.data;
    }

    //Retorna um ponteiro para o filho esquerdo de p . NULL se não tiver.
    public Node left(Node p){
        if(p.left == null){
            return null;
        }
        return p.left;
    }

    //Retorna um ponteiro para o filho direito de p . NULL se não tiver.
    public Node right(Node p){
        if(p.right == null){
            return null;
        }
        return p.right;
    }

    //Retorna um ponteiro para o pai de p . NULL se não tiver.
    public Node father(Node p){
        if(p.father == null){
            return null;
        }
        return p.father;
    }

    //Retorna um ponteiro para o irmão de p. NULL se não tiver.
    public Node brother(Node p){
        if(isLeft(p)){
            if(p.right == null){
                return null;
            }
            return p.right;
        }else{
            if(p.left == null){
                return null;
            }
            return p.left;
        }
    }

    //TRUE se nd for um filho esquerdo de algum outro nó na árvore e FALSE em caso contrário.
    public boolean isLeft(Node p){
        if(p.father.left.data.isEqual(p.data)){
            return true;
        }
        return false;
    }

    //isright(p): TRUE se nd for um filho direito de algum outro nó na árvore e FALSE em caso contrário.
    public boolean isRight(Node p){
        if(p.father.right.data.isEqual(p.data)){
            return true;
        }
        return false;
    }

    //Procura um nó
    public Node findNode(Person p, Node root){
        if(p.getAge() == root.data.getAge()){
            return root;
        }else if(p.getAge() < root.data.getAge()){
            return findNode(p, root.left);
        }else{
            return findNode(p, root.right);
        }
    }
}