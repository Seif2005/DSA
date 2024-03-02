package Data_Structures;

public class PriorityQueueArrayV2 {
    //this version uses selection sort
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueueArrayV2(int maxSize) {
        this.nItems = 0;
        this.queueArray = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int num){
        //you insert in an unsorted array
        queueArray[nItems++] = num;

    }

    public int remove(){
        //selection sort here
        int min  = queueArray[0];
        int minindex = 0;
        for (int i = 1; i < nItems; i++) {
            if(queueArray[i]<min){
                min = queueArray[i];
                minindex = i;
            }
        }
        //replacing the last element in the queue instead of the item we will remove
        queueArray[minindex] = queueArray[nItems-1];
        nItems--;
        return min;
    }
    public int peekmin(){
        int min  = queueArray[0];
        for (int i = 1; i < nItems; i++) {
            if(queueArray[i]<min){
                min = queueArray[i];
            }
        }
        return min;
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
