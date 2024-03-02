package Data_Structures;
public class ArrayStack {
    private int[] ArrayStack;
    private int MaxSize;
    private int top;
    //constructor
    public ArrayStack(int MaxSize){
        this.top=-1;
        this.MaxSize=MaxSize;
        this.ArrayStack = new int[MaxSize];
    }
    //region Methods
    public void push(int number){
        this.ArrayStack[++top]=number;
    }
    public int pop(){
        return this.ArrayStack[top--];
    }
    public int top(){
        return this.ArrayStack[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==MaxSize-1;
    }
    public int size(){
        return top+1;
    }
    //extra method for a question
    public int search(int number){
        int index = top;
        while(index!=-1){
            if(ArrayStack[index]==number){
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
        int[] external = new int[this.MaxSize];
        int j=0;
        for(int i=MaxSize-1;i>=0;i--){
            external[j]=this.ArrayStack[i];
            j++;
        }
        this.ArrayStack=external;
    }
    //endregion
}
