
import java.lang.*;
import java.util.*;

public class SearchSort {

    private int[] nums;
    
    public SearchSort(int[] nums){
        
    }
    
    public static void printlnArray(int a[])
    {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (j == 10)//move for next line
            {
                System.out.println("\n");
                j = 0;
            }
            System.out.print(a[i] + " ");
            j++;
        }
    }
    private static int indexSmallest(int[] arr, int start) {
        int indexMin = start;
        
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[indexMin]) {
                indexMin = i;
            }
        }
    }
        
    private static int swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    
    
}
