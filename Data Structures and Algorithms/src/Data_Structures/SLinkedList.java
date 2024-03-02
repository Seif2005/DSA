package Data_Structures;

public class SLinkedList {
    //inner class of Node
    public static class Node{
        public Comparable data;
        public Node next;
        public Node(Comparable data){
            this.data = data;
        }
        public String toString(){
            return ""+data;
        }
    }
    private Node head;
    public SLinkedList(){
        head = null;
    }
    public boolean isEmpty(){
        return head ==null;
    }
    public void insertFirst(Comparable o){
        Node node = new Node(o);
        node.next = head;
        head = node;
    }
    public Node removeFirst(){
        Node extract = head;
        head = head.next;
        return extract;
    }
    public String toString(){
        Node current = head;
        String result = ""+current.data;
        current = current.next;
        while (current!=null){
            result = result + "=>"+current.data;
            current = current.next;
        }
        return result+"=>null";
    }
    public Node delete(Comparable comp){
        Node current = head;
        Node previous = null;
        while (current.data.compareTo(comp)!=0) {
            if (current.next==null){
                return null;
            }else {
                previous = current;
                current = current.next;
            }
        }
        if(current==head){
            current=current.next;
        }
        else {
            previous.next = current.next;
        }
        return current;
    }
    public boolean isMember(Comparable obj){
        boolean found = false;
        Node current = head;
        while(current!=null&&!found){
            if (current.data.compareTo(obj)==0){
                found = true;
            }
            current = current.next;
        }
        return found;
    }
    public void insertLast(Comparable comp){
        Node node = new Node(comp);
        if (this.isEmpty()){
            head = node;
            return;
        }
        Node current = head;
        while (current.next!=null){
            current = current.next;
        }
        current.next = node;
    }
    public Node removeLast(){
        Node current = head;
        Node previous = null;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }if (previous == null){
            head = null;
        }else {
            previous.next = null;
        }
        return current;
    }

    public void insertAfter(Comparable value, Comparable valueafter){
        if(!isMember(valueafter)){
            return;
        }
        Node node = new Node(value);
        Node current = head;
        Node previous;
        while(current.data.compareTo(valueafter)!=0&&current!=null){
            previous = current;
            current = current.next;
        }
        if(current==null){
            return;
        }
        previous = current;
        current = current.next;
        node.next = current;
        previous.next = node;
    }
    public void insertBefore(Comparable value, Comparable valuebefore){
        if(!isMember(valuebefore)){
            return;
        }
        Node node = new Node(value);
        Node current = head;
        Node previous = null;
        while(current.data.compareTo(valuebefore)!=0&&current!=null){
            previous = current;
            current = current.next;
        }
        if(current==null){
            return;
        }
        node.next = current;
        previous.next = node;
    }
    public void replace(Comparable value, Comparable location){
        if(!isMember(location)){
            return;
        }
        Node node = new Node(value);
        Node current = head;
        Node previous = null;
        //making the current pointer point at the location we need and previous to the node just before that
        while(current.data.compareTo(location)!=0&&current!=null){
            previous = current;
            current = current.next;
        }
        if(current==null){
            return;
        }
        node.next = current.next;
        previous.next = node;
    }
    // for PA7.5
    /*public void DeleteMN(int M, int N){
        Node current = head;
        while(current!=null){
            
        }
    }*/
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
    public void mix(){
        int size = this.size();
        int counter = size/2;
        if (size>=3){
            Node current = head;
            for (int i = 0; i < counter; i++) {
                Node extract  = this.removeLast();
                extract.next = current.next;
                current.next = extract;
                current = current.next.next;
            }
        }
    }
    public void deleteMN(int M, int N){
        Node current = head;
        if (isEmpty()||M>=size()){
            return;
        }
        boolean atstart = true;
        while(current!=null){
            //passing elements
            if (atstart){
                for (int i=0;i<M-1; i++){
                    //checking if this is the end of the list
                    if(current.next!=null){
                        current = current.next;
                    }
                    else{
                        return;
                    }
                }
                atstart = false;
            }else{
                for (int i=0;i<M; i++){
                    //checking if this is the end of the list
                    if(current.next!=null){
                        current = current.next;
                    }
                    else{
                        return;
                    }
                }
            }

            //deleting elements
            for (int i = 0; i < N; i++) {
                //checking if there is an element to delete
                if (current.next!=null){
                    current.next = current.next.next;
                }else return;
            }
        }
    }
    public void cutList(){
        int size = size();
        Node current = head;
        for (int i = 0; i < size / 2; i++) {
            current = current.next;
        }
        Node next  = current.next;
        current.next = null;
        Node second = next;
        while(next.next!=null){
            next = next.next;
        }
        next.next = head;
        head = second;
    }

}
