package Data_Structures;

public class ObjPriorityQueue {
    //used to hold classes that implement the comparable interface
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize; // Maximum Capacity
    private Comparable[] queueArray; // Array that holds the items
    private int nItems;
    public ObjPriorityQueue(int maxSize) {
        this.maxSize = maxSize; // set array size
        queueArray = new Comparable[maxSize]; // create array
        nItems = 0; // no items yet
    }

    public void insert(Comparable num){
        //for empty queue
        if (nItems==0){
            queueArray[nItems++] =  num;
        }
        //search for location of the element
        else{
            int j;
            for( j=nItems-1;j>=0;j--){
                if (num.compareTo(queueArray[j])<0){
                    //shifting
                    queueArray[j+1] =queueArray[j];
                }
                else break;
            }
            //inserting element
            queueArray[j+1] = num;
            nItems++;
        }
    }

    public Comparable remove(){
        nItems--;
        return queueArray[nItems];
    }
    public Comparable peekmin(){
        return queueArray[nItems-1];
    }
    public boolean isEmpty(){
        return nItems ==0;
    }
    public boolean isFull(){
        return nItems==maxSize;
    }
    public int size(){
        return nItems;
    }

}
