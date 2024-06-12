
public class ShellSort{
        
    final static int MAX_COLM = 4;

   public static void shellSort(int arr[][], int n)
    {
        int temp = 0, columnToSort = 2;

        for(int gap = n/2; gap >= 1; gap = gap/2){
            for(int i = gap; i < n; i++){
                for(int j = i; j >= gap && arr[j-gap][columnToSort] > arr[j][columnToSort]; j = j - gap){
                    for(int column = 0; column < MAX_COLM; column++){
                        temp = arr[j-gap][column];
                        arr[j-gap][column] = arr[j][column];
                        arr[j][column] = temp;
                    }
                }
            }
        }
    }
   
  public static void main(String[] args) {

    }
}