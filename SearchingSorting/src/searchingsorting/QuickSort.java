import java.util.Collections;
import java.util.Vector;

public class QuickSort {

  private static void mergeSort(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        int i = leftStart;   
        int j = rightStart;  
        int k = leftStart;   
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            } else {
                temp[k] = arr[j];
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
    }
}