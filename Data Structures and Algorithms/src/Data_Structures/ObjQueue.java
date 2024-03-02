package Data_Structures;

public class ObjQueue {
    private int maxSize;
    private int front;
    private int  rear;
    private int nItems;
    private Object[] queArray;
    //constructor
    public ObjQueue(int MaxSize){
        this.maxSize = MaxSize;
        queArray = new Object[MaxSize];
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }
    public void enqueue(Object Obj){
        //circular loop
        if (rear==maxSize-1){
            rear = -1;
        }
        queArray[++rear] = Obj;
        nItems++;
    }
    public Object dequeue(){
        Object result= queArray[front];
        front++;
        if (front== maxSize){
            front = 0;
        }
        nItems--;
        return result;
    }
    public Object peek(){
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

