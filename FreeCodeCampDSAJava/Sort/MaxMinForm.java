// Rearrange the array in Max/Min form
// i/p arr = {1,2,3,4,5,6,7} 
// o/p arr = {7,1,6,2,5,3,4} 
// first large,small , second large,small and so on

public class MaxMinForm {
    public void arrange(int[] arr){
        
    }

    public void printArray(int[] arr){
      for(int i =0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
      }
    }
    public static void main(String[] args) {
        MaxMinForm obj = new MaxMinForm();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        obj.arrange(arr);
        obj.printArray(arr);

    }
}
