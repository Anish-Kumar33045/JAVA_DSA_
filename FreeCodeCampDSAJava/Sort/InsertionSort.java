// Insertion Sort
// conider first element is already sorted
//  we divide array into sorted and unsorted parts 
//procedure chatgpt


public class InsertionSort {

    public void printArray(int[] arr){
  for(int i = 0 ; i<arr.length; i++){
    System.out.print(arr[i]+" ");
  }
  System.out.println();
    }

     public void insertionSort (int[] arr){
        for(int i=1 ; i<arr.length ; i++){
           int temp = arr[i];
           int j = i-1;

           while(j>=0 && arr[j] > temp){
            arr[j+1] = arr[j]; // right shift
            j--;
           }
           arr[j+1] = temp; 
        }
     }
    public static void main(String[] args) {
        int[] arr = new int[] {5,1,2,9,10};
        InsertionSort obj = new InsertionSort();
        obj.printArray(arr);
        obj.insertionSort(arr);
        System.out.println("Insertion Sort : ");
        obj.printArray(arr);
    }
}
