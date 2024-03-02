package Exams;

import Data_Structures.ObjQueue;
import Data_Structures.ObjStackArray;

public class QueueSelectionSortByStakc {
    public static void queueSelectionSort(ObjQueue q){
        //allowed only to use enqueue dequeue size and isEmpty
        /*The idea of this algorithm is simple
        * we just loop on the queue by dequeuing and enquing to find the corresponding largest element in it that is just smaller than the one we store in the stack
        * then we add it to our stack where we save the largest at the bottom
        * then we empty the stack into the queue where it will be sorted*/
        ObjStackArray myStack = new ObjStackArray(q.size());
        for (int i=0;i< q.size();i++) {
            int largestyet = 0;
            int number = 0;
            //finding corresponding largest number
            for (int j = 0; j < q.size(); j++) {
                number = (int) q.dequeue();
                q.enqueue(number);
                if (number > largestyet && myStack.isEmpty()) {
                    largestyet = number;
                } else if (number > largestyet && number < (int) myStack.peek()) {
                    largestyet = number;
                }
            }
            myStack.push(largestyet);
        }
        while(!myStack.isEmpty()){
            q.dequeue();
            q.enqueue(myStack.pop());
        }
    }
}
