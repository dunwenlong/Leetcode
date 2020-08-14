/**
 * @author Dun
 */
public class Quicksort {
    public void quicksort(int[] arr){
        int n = arr.length;
        inQuickSort(arr, 0, n-1);
    }
    private void inQuickSort(int[] arr, int l, int r){
        if(l>=r) {
            return;
        }
        int q = partition(arr, l, r);
        inQuickSort(arr, l, q-1);
        inQuickSort(arr, q+1,r);

    }
    private int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i=l;
        int j=l;
        while(j<=r){
            if(i==j){
                if(arr[j]<=pivot) {
                    i++;
                }
            }else{
                if(arr[j]<=pivot){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
            j++;
        }
        return i-1;
    }
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 1, 1, 1};
        Quicksort quicksort = new Quicksort();
        quicksort.quicksort(test);
        for (int num : test) {
            System.out.print(num+" ");
        }
    }
}
