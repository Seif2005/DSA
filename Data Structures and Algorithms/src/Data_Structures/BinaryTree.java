package Data_Structures;

public class BinaryTree {
    private class Node{
        public Comparable data;
        public Node left;
        public Node right;
        public Node(Comparable data){
            this(data,null,null);
        }
        public Node(Comparable data, Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public String toString(){
            return ""+data;
        }
    }
    public Node root;
    public BinaryTree(){
        this.root = null;
    }
    public boolean searchiterative(Comparable searchvalue){
        Node current  = root;
        while(current!=null){
            if (current.data.compareTo(searchvalue)==0){
                return true;
            } else if (searchvalue.compareTo(current.data)>0) {
                current = current.right;
            }else {
                current = current.left;
            }
        }
        return false;
    }
    public boolean searchrec(Comparable searchvalue){
        return helper(root,searchvalue);
    }
    private boolean helper(Node node,Comparable searchvalue){
        if (node==null){
            return false;
        }
        if (node.data.compareTo(searchvalue)==0){
            return true;
        }else {
            if (searchvalue.compareTo(node.data)>0){
                return helper(node.right,searchvalue);
            }else {
                 return helper(node.left,searchvalue);
            }
        }
    }
    public void insert(Comparable val){
        //we will insert as a leaf
        Node node  = new Node(val);
        Node current = root;
        Node Parent = null;
        while(current!=null){
            if (current.data.compareTo(val)==0){
                return;//no insertion of duplicates
            }
            if (current.data.compareTo(val)>0){
                Parent = current;
                current = current.left;
            }else{
                Parent = current;
                current = current.right;
            }
        }
        if (Parent==null){
            root = node;
        }
        else {
            if (Parent.data.compareTo(val)>0){
                Parent.left = node;
            }else {
                Parent.right=node;
            }
        }
    }
    public Node delete(Comparable data){
        if (root==null){
            return null;
        }
        Node current = root;
        Node parent = root;
        Node substitute  = root;
        //to follow the path leading to the node that gets deleted
        boolean isRight = true;
        //searching for the node we want to delete
        while(current.data.compareTo(data)!=0){
            if (current.data.compareTo(data)>0){
                isRight = false;
                parent = current;
                current = current.left;
            }else{
                isRight = true;
                parent = current;
                current = current.right;
            }
            //not found case
            if (current==null){
                return null;
            }
        }
        //cases 1 and 2 of having no children or single child
        //case 1
        if (current.left==null&&current.right==null){
            substitute = null;
        }
        //case 2
        else if (current.right==null){
            substitute = current.left;
        }
        else if (current.left==null){
            substitute = current.right;
        }
        //case 3 of having two children
        //get the right subtree's left most descendant and substitute
        else{
            Node successor = current.right;
            Node successorParent = current;
            while(successor.left!=null){
                successorParent = successor;
                successor = successor.left;
            }
            //this is our sub
            substitute = successor;
            if (successorParent!=current){
                //modifying the end of list where we take the sub
                successorParent.left = successor.right;
                //here it takes connection instead of deleted one
                substitute.right = current.right;
            }
            substitute.left = current.left;
        }
        //replacing node
        if (current==root){
            root = substitute;
        } else if (isRight) {
            parent.right = substitute;
        }else{
            parent.left = substitute;
        }
        return current;
    }
    public void InorderTraversal(){
        inorder(root);
        System.out.println();
    }
    private void inorder(Node node){
        if (node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public void PreOrderTraversal(){
        preorder(root);
        System.out.println();
    }
    private void preorder(Node node){
        if (node==null){
            return;
        }
        System.out.print(node+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void PostOrderTraversal(){
        postorder(root);
        System.out.println();
    }
    private void postorder(Node node){
        if (node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node+" ");
    }

    //PA 9_6
    public int level(Comparable key){
        if (searchiterative(key)==false){
            return -1;
        }
        return levelHelper(0,key,root);
    }
    private int levelHelper(int level,Comparable key, Node node){
        if (node==null){
            return 0;
        }
        if (node.data.compareTo(key)==0){
            return level;
        }
        else {
            level++;
            return levelHelper(level,key,node.right) + levelHelper(level,key,node.left);
        }
    }
    public int findMax(){
        if (root==null){
            return -1;
        }
        int[] max = {0};
        maxHelper(root,max);
        return max[0];
    }
    private void maxHelper(Node node,int[] max){
        if (node==null){
            return;
        }
        if (node.data.compareTo(max[0])>0){
            max[0] = (int)node.data;
        }
        maxHelper(node.left,max);
        maxHelper(node.right,max);
    }
}
