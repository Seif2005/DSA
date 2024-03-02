import java.sql.Array;
import java.util.Arrays;
public class Algorithms {
    //region Search Algorithms
    //linear search
    public static boolean LinearSearch(int searchValue,int[]arr){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==searchValue){
                return true;
            }
        }
        return false;
    }
    //binary Search
    public static boolean BinarySearch(int searchValue,int[]arr){
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int middle=(start+end)/2;
            if (arr[middle]==searchValue){
                return true;
            }
            else if (searchValue>arr[middle]){
                start = middle+1;
            }
            else if(searchValue<arr[middle]){
                end=middle-1;
            }
        }
        return false;
    }
    //Recursive Binary Search
    public static boolean RecBinarySearch(int searchValue,int[]arr){
        int start=0;
        int end = arr.length-1;
        int middle=(start+end)/2;
        if (arr.length==1){
            return arr[middle] == searchValue;
        }
        if (arr[middle]==searchValue){
            return true;
        }
        else if (searchValue>arr[middle]){
            return RecBinarySearch(searchValue,Arrays.copyOfRange(arr,middle+1,arr.length));
        }
        else if(searchValue<arr[middle]){
            return RecBinarySearch(searchValue,Arrays.copyOfRange(arr,start,middle));
        }
        return false;
    }
    //endregion
    //region Sort Algorithms
    // Selection Sort
    public static int[] SelectionSort(int[] arr){
        for (int i=0;i< arr.length;i++){
            int temp=0;
            int minValue=arr[i];
            int minValueLocation=i;
            for (int j=i;j<arr.length;j++){
                if (arr[j]<minValue){
                    minValue=arr[j];
                    minValueLocation=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[minValueLocation];
            arr[minValueLocation]=temp;
        }
        return arr;
    }
    //Bubble Sort
    public static int[] BubbleSort(int[] arr){
        boolean swap=true;
        int temp;
        while(swap){
            swap=false;
            for (int i=0;i< arr.length-1;i++){
                if (arr[i]>arr[i+1]){
                    //swapping
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swap=true;
                }
            }
        }
        return arr;
    }
    public static int[] CountingSort(int[] array){
        int largest=array[0];
        int[] farr= new int[array.length];
        //finding main array size
        for(int i =1;i<array.length;i++){
            if (array[i]>largest){
                largest=array[i];
            }
        }
        int[] arrnums= new int[largest+1];
        for (int i=0;i< array.length;i++){
            int numb=array[i];
            arrnums[numb]++;
        }
        int index=0;
        for (int i =0;i<arrnums.length;i++){
            for (int j =0;j<arrnums[i];j++){
                farr[index]=i;
                index++;
            }
        }
        return farr;
    }
    public static int[] MergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        else{
            int[] firsthalf=MergeSort(Arrays.copyOfRange(arr,0,arr.length/2));
            int[] secondhalf=MergeSort(Arrays.copyOfRange(arr,arr.length/2,arr.length));
            int TotalLength=firsthalf.length+ secondhalf.length;
            int i=0;
            int j =0;
            int[] last = new int[TotalLength];
            for(int position=0;position<TotalLength;position++){
                if (i== firsthalf.length){
                    last[position]=secondhalf[j];
                    j++;
                }
                else if (j== secondhalf.length){
                    last[position]=firsthalf[i];
                    i++;
                }
                else {
                    if(firsthalf[i]<=secondhalf[j]){
                        last[position]=firsthalf[i];
                        i++;
                    }
                    else {
                        last[position]=secondhalf[j];
                        j++;
                    }
                }
            }
            return last;
        }

    }
    public static int[] InsertionSort(int[] arr){
        int temp;
        int j;
        for (int i=1;i< arr.length;i++){
            temp=arr[i];
            j=i-1;
            while(j>=0 && temp<arr[j]){
                //shifting that element
                arr[j+1]=arr[j];
                j--;
                if (j<0||temp>=arr[j]){
                    arr[j+1]=temp;
                    break;
                }
            }
        }
        return arr;
    }
    public static int[] InsertionSortSlim(int[] arr){
        for (int i=1;i<arr.length;i++){
            int value=arr[i];
            int j;
            //loop terminates if reached beginning of array or found the location of element by an element less than it to be placed after it
            for (j = i-1;j>=0&&arr[j]>value;j--){
                //shifting to create space backwards
                arr[j+1]=arr[j];
            }
            //placing the element
            arr[j+1]=value;
        }
        return arr;
    }
    public static int[] IndexSort(int[] array){
        int[] arr= new int[array.length];
        for( int i=0;i< array.length;i++){
            int number = array[i];
            int location=0;
            int dupcounter=0;
            for(int j=0;j< arr.length;j++){
                if (number>array[j]){
                    location++;
                }
                if (number==array[j]){
                    dupcounter++;
                }
            }
            for (int j=location;j<location+dupcounter;j++){
                arr[j]=number;
            }

        }
        return arr;
    }
    //endregion
    
}
