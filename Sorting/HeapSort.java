class Solution {

    // Main function to perform heap sort
    public static void heapSort(int arr[], int n) {

        //  Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //  Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i
    static void heapify(int arr[], int n, int i) {
        int largest = i;      // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }
}



public class HeapSort {
  public static void main(String[] args) {
      
    int arr[]={2,5,6,3,4,5,6,7,3};
    int n=arr.length;

    Solution.heapSort(arr, n);

    // Print sorted array
        for (int x : arr) {
            System.out.print(x + " ");
        }
  

    
 }
}
