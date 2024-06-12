
public class InsertionSort {

    public static void InsertionSort(int[] array) {
        int i, j;

        for (j = 1; j < array.length; j++) {
            int element = array[j];
            for (i = j - 1; (i >= 0) && (array[i] < element); i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = element;
        }
    }

    public static void main(String[] args) {

    }

}
