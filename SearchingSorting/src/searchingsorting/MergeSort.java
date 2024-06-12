
public class MergeSort {

    public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left+right)/2;
    mergeSort(array, left, mid);
    mergeSort(array, mid+1, right);
}
    void merge(int[] array, int left, int mid, int right) {
        int Left = mid - left + 1;
        int Right = right - mid;

        int leftA[] = new int[Left];
        int rightA[] = new int[Right];

        for (int i = 0; i < Left; i++) {
            leftA[i] = array[left + i];
        }
        for (int i = 0; i < Right; i++) {
            rightA[i] = array[mid + i + 1];
        }

        int leftI = 0;
        int rightI = 0;

        for (int i = left; i < right + 1; i++) {
            if (leftI < Left && rightI < Right) {
                if (leftA[leftI] < rightA[rightI]) {
                    array[i] = leftA[leftI];
                    leftI++;
                } else {
                    array[i] = rightA[rightI];
                    rightI++;
                }
            } 
            else if (leftI < Left) {
                array[i] = leftA[leftI];
                leftI++;
            } 
            else if (rightI < Right) {
                array[i] = rightA[rightI];
                rightI++;
            }
        }
    }
}