package Module_2;

/*
 * MergeSort Algorithm
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++)
            arr[left + p] = temp[p];
    }
}
