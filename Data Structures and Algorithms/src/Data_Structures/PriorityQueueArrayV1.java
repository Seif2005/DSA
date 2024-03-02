package Data_Structures;

public class PriorityQueueArrayV1 {
    //this version uses insertion sort
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueueArrayV1(int maxSize) {
        this.nItems = 0;
        this.queueArray = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int num){
        //for empty queue
        if (nItems==0){
            queueArray[nItems++] = num;
        }
        //search for location of the element
        else{
            int j;
            for( j=nItems-1;j>=0;j--){
                if (num>queueArray[j]){
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

    public int remove(){
        nItems--;
        return queueArray[nItems];
    }
    public int peekmin(){
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
