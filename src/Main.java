import java.util.Arrays;
import java.util.Random;
/***********************************
 * Algoritmid ja andmestruktuurid. LTAT.03.005
 * 2025/2026 sügissemester
 *
 * Kodutöö nr 1
 * Teema: Algoritmide vordsus(?)
 *
 * Autor: Erik Petrov
 **********************************/

public class Main {
    public static void main(String[] args) {
        int[] arrSizes = {0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144};
        long[][] arrResults = new long[Sorter.Functions.values().length][arrSizes.length]; //results in nanoseconds
        for (Sorter.Functions i : Sorter.Functions.values()) { //bubble then merge
            for (int j = 0; j < arrSizes.length; j++) { //every array size
                int[] a = generateArray(arrSizes[j]);
                long startTime = System.nanoTime();
                if(i.equals(Sorter.Functions.BubbleSort)) {
                    Sorter.BubbleSort(a);
                } else{
                    Sorter.MergeSort(a, 0, a.length-1);
                }
                assert isSorted(a) : i.name()+" failed to sort array["+j+"]\na="+Arrays.toString(a);
                arrResults[i.ordinal()][j] = (System.nanoTime() - startTime);
            }
        }
        System.out.println(Arrays.deepToString(arrResults));
    }

    /**
     * Generates an array of random integers, when 1024 -> makes an ordered array
     * @param size array size
     * @return generated array
     */
    public static int[] generateArray(int size) {
        if (size == 1024){ //just an already sorted array at the end
            int[] arr = new int[1024];
            for (int i = 0; i < arr.length; i++){
                arr[i] = i;
            }
            return arr;
        }
        int[] arr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return arr;
    }

    /**
     * Checks if the array is sorted
     * @param arr the array
     * @return array sorted status
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}