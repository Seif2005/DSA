package Data_Structures;

public interface StackI {
    public boolean isEmpty();
    public boolean isFull();
    public Object peek();
    Object pop();
    public void push(Object item);
    public int size();
}