package Exams;

import Data_Structures.ArrayStack;

public class OrderedStack {
    ArrayStack MainStack;
    ArrayStack extra;
    public OrderedStack(int maxsize){
        MainStack = new ArrayStack(maxsize);
        extra = new ArrayStack(maxsize);
    }
    public void pushOrdered(int num){
        if (MainStack.isEmpty()){
            MainStack.push(num);
        }
        else {
            while(!MainStack.isEmpty() &&num> MainStack.top()) {
                    extra.push(MainStack.pop());
                }
            MainStack.push(num);
            while(!extra.isEmpty()) MainStack.push(extra.pop());
        }
    }
    public int popOrdered(){
        return MainStack.pop();
    }

}
