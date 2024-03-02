package Data_Structures;
public class ObjStackArray implements StackI {
    private Object[] ArrayStack;
    private final int MaxSize;
    private int top;
    //constructor
    public ObjStackArray(int MaxSize){
        this.top=-1;
        this.MaxSize=MaxSize;
        this.ArrayStack = new Object[MaxSize];
    }
    //region Methods
    public Object pop(){
        return this.ArrayStack[top--];
    }

    public void push(Object item) {
        this.ArrayStack[++top]=item;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==MaxSize-1;
    }

    public Object peek() {
        return this.ArrayStack[top];
    }

    public int size(){
        return top+1;
    }
    //extra method for a question
    public Object search(Object Obj){
        int index = top;
        while(index!=-1){
            if(this.ArrayStack[index].equals(Obj)){
                return top-index;
            }
            else{
                index--;
            }
        }
        return index;
    }
    //extra method for a question
    public void reverse(){
        Object[] external = new Object[this.MaxSize];
        int j=0;
        for(int i=MaxSize-1;i>=0;i--){
            external[j]=this.ArrayStack[i];
            j++;
        }
        this.ArrayStack=external;
    }
    //endregion
}
