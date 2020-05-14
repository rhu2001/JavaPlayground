import java.util.*;

/**
 * Playground to mess around with Java.
 *
 * @author Richard Hu
 */

public class JavaPlayground {
    static final double root2 = Math.sqrt(2);

    public static void main(String[] args) {
        int[] arr1 = new int[] {5, 4, 3, 2, 1};
        int[] arr2 = new int[] {1, 2, 3, 4, 5};
        int[] arr3 = new int[] {3, -5, 2, 1, -2, -4, 3, 5, 5, 4, 1, -3, -2, -2, -1, -4, -3};
        int[] arr4 = new int[] {1429, 3291, 7683, 1337, 192, 594, 4242, 9001, 4392, 129, 1000};
        selectionSort(new int[] {1429, 3291, 7683, 1337, 192, 594, 4242, 9001, 4392, 129, 1000});
        insertionSort(new int[] {1429, 3291, 7683, 1337, 192, 594, 4242, 9001, 4392, 129, 1000});
        mergeSort(new int[] {1429, 3291, 7683, 1337, 192, 594, 4242, 9001, 4392, 129, 1000});
        heapSort(new int[] {1429, 3291, 7683, 1337, 192, 594, 4242, 9001, 4392, 129, 1000});
    }

    static void heapSort(int[] arr) {
        System.out.println("Heapsort on:\n" + Arrays.toString(arr));
        System.out.println("Initial heapification:");
        for (int i = 1; i < arr.length; i++) {
            int ind = i;
            while (ind > 0 && arr[ind] > arr[(ind + 1) / 2 - 1]) {
                swap(arr, ind, (ind + 1) / 2 - 1);
                ind = (ind + 1) / 2 - 1;
                System.out.println(Arrays.toString(arr));
            }
        }

        System.out.println("Remove max:");
        int size = arr.length;
        while (size > 1) {
            swap(arr, 0, size - 1);
            size--;

            int ind = 0;
            while ((2 * (ind + 1) - 1 < size || 2 * (ind + 1) < size) && (arr[ind] < arr[2 * (ind + 1) - 1] || arr[ind] < arr[2 * (ind + 1)])) {
                if (2 * (ind + 1) - 1 < size && 2 * (ind + 1) < size) {
                    if (arr[ind] < arr[2 * (ind + 1) - 1] && arr[ind] < arr[2 * (ind + 1)]) {
                        if (arr[2 * (ind + 1) - 1] > arr[2 * (ind + 1)]) {
                            swap(arr, ind, 2 * (ind + 1) - 1);
                            ind = 2 * (ind + 1) - 1;
                        } else {
                            swap(arr, ind, 2 * (ind + 1));
                            ind = 2 * (ind + 1);
                        }
                    } else if (arr[ind] < arr[2 * (ind + 1) - 1]) {
                        swap(arr, ind, 2 * (ind + 1) - 1);
                        ind = 2 * (ind + 1) - 1;
                    } else {
                        swap(arr, ind, 2 * (ind + 1));
                        ind = 2 * (ind + 1);
                    }
                } else if (2 * (ind + 1) - 1 < size) {
                    if (arr[ind] < arr[2 * (ind + 1) - 1]) {
                        swap(arr, ind, 2 * (ind + 1) - 1);
                        ind = 2 * (ind + 1) - 1;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        System.out.println("Merge sort on:\n" + Arrays.toString(arr));
        System.out.println();
        mergeSortSubArr(arr, 0, arr.length - 1);
        System.out.println();
    }

    static void insertionSort(int[] arr) {
        System.out.println("Insertion sort on:\n" + Arrays.toString(arr));
        System.out.println();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    static void selectionSort(int[] arr) {
        System.out.println("Selection sort on:\n" + Arrays.toString(arr));
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }

    static void merge(int arr[], int start, int mid, int end) {
        int start2 = mid + 1;

        if (arr[mid] <= arr[start2]) {
            return;
        }

        while (start <= mid && start2 <= end) {
            if (arr[start] <= arr[start2]) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;

                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;

                start++;
                mid++;
                start2++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortSubArr(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSortSubArr(arr, l, m);
            mergeSortSubArr(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void swap(int[] arr, int i1, int i2) {
        if (i1 != i2) {
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }

}