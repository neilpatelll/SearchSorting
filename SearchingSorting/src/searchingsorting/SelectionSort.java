
public class SelectionSort {
    
    final static int MAX_COLM = 4;

   public static void selectionSort(int arr[][], int limit)
    {
        int temp = 0, iOfLargest = 0, columnToSort = 1;

        for(; limit > 0; limit--){
            iOfLargest = 0;
            for(int index = 1; index <= limit; index++){
                if( arr[index][columnToSort] < arr[iOfLargest][columnToSort] ){
                    iOfLargest = index;
                }
            }
            if(limit != iOfLargest){
                for(int j = 0; j < MAX_COLM; j++){
                    temp = arr[limit][j];
                    arr[limit][j] = arr[iOfLargest][j];
                    arr[iOfLargest][j] = temp;
                }
            }
        }
    }

}

