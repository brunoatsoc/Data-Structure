public class Tree{
    private Node root;

    public Tree(){
        root = null;
    }

    public Tree(Person i){
        insertTree(i);
    }

    public void setTree(Person p){
        Person i = new Person(p.getAge(), p.getName());
        insertTree(i);
    }

    private Node createNode(Node node, Person i){
        node.data = i;
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
}