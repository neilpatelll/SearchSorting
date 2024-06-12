import java.util.*;


public class SearchSorts {

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return - low - 1;
    }
    
    public static int recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }
    
     private static int recursiveBinarySearch(int[] list, int key, int low, int high)  {
        if (low > high)
            return -low -1;
        
        int mid = (low + high)/2 ;
        if(key < list[mid])
            return recursiveBinarySearch(list, key, low, mid-1);
        else if(key == list[mid])
            return mid;
        else
            return recursiveBinarySearch(list, key, mid + 1, high);
     }  
                          
    
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    
    public static int linearSearchRecursive(int[] input, int key, int index) {
            if (index == input.length - 1) {
                return -1;
            }
            if (input[index] == key) {
                return index;
            } else {
                return linearSearchRecursive(input, key, ++index); 
            }
        }

    
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < currentMin) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
