import java.util.Arrays;

public class Sorter {
    /**
     * Bubble sort implementation
     * @param arr array to sort
     * @return sorted array
     */
    public static int[] BubbleSort(int[] arr ) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Merge sort implementation
     * <a href="https://www.programiz.com/dsa/merge-sort">source</a>
     *
     * @param arr array to sort
     * @param f   index from
     * @param t   index to
     */
    public static void MergeSort(int[] arr, int f, int t){
        if (f < t) {
            int mid = (t + f) / 2;

            MergeSort(arr, f, mid);
            MergeSort(arr, mid + 1, t);

            merge(arr, f, mid, t);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = arr[q + 1 + j];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    public enum Functions{
        BubbleSort,
        MergeSort
    }
}
