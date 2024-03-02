package Data_Structures;

public class ArrayQueue {
    private final int maxSize;
    private int front;
    private int  rear;
    private int nItems;
    private int[] queArray;
    //constructor
    public ArrayQueue(int MaxSize){
        this.maxSize = MaxSize;
        queArray = new int[MaxSize];
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }
    public void enqueue(int number){
        //circular loop
        if (rear==maxSize-1){
            rear = -1;
        }
        queArray[++rear] = number;
        nItems++;
    }
    public int dequeue(){
    int result= queArray[front];
    front++;
    if (front== maxSize){
        front = 0;
    }
    nItems--;
    return result;
    }
    public int peek(){
        return queArray[front];
    }
    public boolean isFull(){
        return nItems==maxSize;
    }
    public boolean isEmpty(){
        return nItems==0;
    }
    public int size(){
        return nItems;
    }
}
