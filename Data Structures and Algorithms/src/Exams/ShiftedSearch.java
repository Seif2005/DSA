package Exams;

import Data_Structures.ArrayQueue;


public class ShiftedSearch {
    public static void main(String[] args){
        int key = 21;
        int[] a = {33,40,42,50,1,3,4,5,21,22};
        System.out.println(search(key, a , 4));
    }
    public static int search(int key, int[] a, int shifts){
        ArrayQueue queue = new ArrayQueue(a.length);
        for(int num: a){
            queue.enqueue(num);
        }
        for (int i = 0; i < shifts; i++) {
            queue.enqueue(queue.dequeue());
        }
        int k = 0;
        while(!queue.isEmpty()) {
            a[k] = queue.dequeue();
            k++;
        }
        //binary search part
        int start = 0;
        int end = a.length-1;
        boolean found = false;
        int index = -1;
        int middle;
        while(!found && start<=end){
            middle = (end-start)/2;
            if (a[middle] == key){
                found = true;
                index = middle;
            }
            else if (key>a[middle]){
                start= middle+1;
            }
            else{
                end = middle-1;
            }
        }
        if (!found){
            return index;
        }
        else{
            return (index+shifts)%a.length;
        }
    }
}
