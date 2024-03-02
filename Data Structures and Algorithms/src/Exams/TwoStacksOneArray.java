package Exams;

public class TwoStacksOneArray {
    int top1;
    int top2;
    int[] mainarray;
    int maxsize;

    public TwoStacksOneArray(int maxsize){
        this.maxsize = maxsize;
        this.mainarray = new int[maxsize];
        this.top1= -1;
        this.top2 = mainarray.length;
    }
    public void push1(int num){
        if((top1+1)!=top2){
            mainarray[++top1]=num;
        }
    }
    public void push2(int num){
        if((top1+1)!=top2){
            mainarray[--top2]=num;
        }
    }
    public int pop1(){
        return mainarray[top1--];
    }
    public int pop2(){
        return mainarray[top2++];
    }
    public boolean isEmpty(){
        return (top1==-1)&&(top2==this.mainarray.length);
    }
    public boolean isFull(){
        return (top1+1)==top2;
    }
    public int size() {
        return top1+1 +(mainarray.length-top2);
    }
}
