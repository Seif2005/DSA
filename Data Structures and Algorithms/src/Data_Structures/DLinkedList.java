package Data_Structures;

public class DLinkedList {
    private static class Node{
        public Comparable data;
        public Node next;
        public Node previous;
        public Node(Comparable data){
            this.data = data;
        }
        public String toString(){
            return ""+data;
        }
    }
    private Node head;
    private Node tail;
    public DLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty(){
        return head==null&&tail==null;
    }
    public void insertFirst(Comparable data){
        Node node = new Node(data);
        if (this.isEmpty()){
            tail = node;
        }
        else{
            head.previous = node;
        }
        node.next = head;
        head = node;
    }
    public void insertLast(Comparable data){
        Node node = new Node(data);
        if (this.isEmpty()){
            head = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
    }
    public Node deleteFirst(){
        Node extract = head;
        if (head.next == null){
            tail = null;
        }
        head = head.next;
        head.previous = null;
        return extract;
    }
    public Node deleteLast(){
        Node extract = tail;
        if (tail.previous==null){
            head = null;
        }
        tail = tail.previous;
        tail.next = null;
        return extract;
    }
    public void DisplayForward(){
        Node current = head;
        String res ="null<=>";
        while(current!=null){
            res+=current+"<=>";
            current = current.next;
        }
        res+="null";
        System.out.println(res);
    }
    public void DisplayBackwards(){
        Node current = tail;
        String res = "<=>null";
        while(current!=null){
            res = "<=>"+current+res;
            current = current.previous;
        }
        res = "null"+res;
        System.out.println(res);
    }
    public Node delete(Comparable element){
        Node current = head;
        Node previous = null;
        while(current!=null&&current.data.compareTo(element)!=0){
            previous = current;
            current = current.next;
        }
        if(current==null){
            return null;
        }
        if (current.next==null&&current.previous==null){
            head = null;
            tail = null;
        }
        if (current==head){
            current.next.previous = null;
            head = head.next;
        } else if (current == tail) {
            current.previous.next = null;
            tail = tail.previous;
        }else {
            previous.next = current.next;
            current.next.previous = previous;
        }
        return current;
    }
    public String toString(){
        Node current = tail;
        String res = "<=>null";
        while(current!=null){
            res = "<=>"+current+res;
            current = current.previous;
        }
        res = "null"+res;
        return res;
    }
    public boolean isMember(Comparable element){
        Node current = head;
        while(current!=null&&current.data.compareTo(element)!=0){
            current = current.next;
        }
        if (current==null){
            return false;
        }
        return true;
    }
    //recheck
//    public void replace (Comparable tobereplaced,Comparable replacewith){
//        if (!this.isMember(tobereplaced)) {
//            return;
//        }
//        if (isEmpty()){
//            return;
//        }
//        Node current = head;
//        Node previous = null;
//        while(current!=null&&current.data.compareTo(tobereplaced)!=0){
//            previous = current;
//            current = current.next;
//        }
//        if (current==null){
//            return;
//        }
//        //replacing the element here
//        Node node = new Node(replacewith);
//        node.next = current.next;
//        node.previous = previous;
//        if (previous!=null) {
//            previous.next = node;
//        }
//        else {
//            head = node;
//        }
//        if (current.next!=null) {
//            current.next.previous = node;
//        }
//        else{
//            tail = node;
//        }
//    }
    //incomplete

    public int size(){
        if (this.isEmpty()){
            return 0;
        }else {
            int counter = 1;
            Node current = head;
            while(current.next!=null){
                counter++;
                current = current.next;
            }
            return counter;
        }
    }
    //for Practice Assignment
    public boolean isMemberRec(Comparable comparable){
        return helper(this.head,comparable);
    }
    private boolean helper(Node node,Comparable comparable){
        if (node==null){
            return false;
        }
        if (node.data.compareTo(comparable)==0){
            return true;
        }
        else{
            return helper(node.next,comparable);
        }
    }
}
//public boolean insertAfter(Comparable )
