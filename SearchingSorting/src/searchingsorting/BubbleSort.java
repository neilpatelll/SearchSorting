public class BubbleSort {

        final static int MAX_COLM = 4;

  public static void BubbleSort(int array[]) {
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int j = 1; j < array.length; j++) {
        if (array[j - 1] > array[j]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
          swapped = true;
        }
      }
    }
  }
  
  public static void bubbleSort(int arr[][], int limit) {
        int temp = 0, colSort = 0;

        for (; limit > 0; limit--) {
            for (int index = 0; index < limit; index++) {
                if ( arr[index][colSort] > arr[index + 1][colSort] ) {
                    for (int j = 0; j < MAX_COLM; j++) {
                        temp = arr[index][j];
                        arr[index][j] = arr[index+1][j];
                        arr[index+1][j] = temp;
                    }
                }
            }
        }
    }

  public static void main(String[] args) {
    int[] array = { 7, 8, 5, 2, 5, 3 };
    BubbleSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

}