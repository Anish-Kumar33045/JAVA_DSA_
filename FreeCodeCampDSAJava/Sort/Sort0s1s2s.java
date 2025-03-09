public class Sort0s1s2s {
    // dutch national flag problem
 /*
  *  Array contains elements 0,1,2 only 
   i,j,k --> poniters
   i --> runs along the arrays 
   j --> deals with zero 
   k --> deals with twos
   algorithm :
   when i encounters 0 swaps with j
   when i encounters 2 swaps with k
   when i encounters 1 , i++


  */

  public void threeNumSort(int[] arr){
    int i=0;
    int j=0;
    int k=arr.length-1;

    while(i <= k){
        if(arr[i] == 0){
            swap(arr,i,j);
            i++;
            j++;
        }
        else if(arr[i] == 1){
            i++;
        }
        else if(arr[i] == 2){
            swap(arr,i,k);
            k--;
        }
    }

  }
 public void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
 }
 public void printArray(int[] arr){
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
 }
    public static void main(String[] args) {
        Sort0s1s2s obj = new Sort0s1s2s();
        int[] arr = new int[] {1,2,0,0,2,1,0,1};
        obj.threeNumSort(arr);
        obj.printArray(arr);
    }
}
