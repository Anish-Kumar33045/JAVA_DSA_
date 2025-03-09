

public class Searching {

    // Linear Search 
    public void linearSearch(int[] arr ,int n , int key){
      System.out.println("Linear Search :  "); //any order
      for (int i = 0; i < n; i++) {
         if(arr[i] == key){
            System.out.println("Element "+key +" found at pos "+ (i+1) );
            return;
         }
      }
      System.out.println("Element not found !!!");
   }
   
   //  binary Search 
   public void binarySearch(int[] arr , int n , int key){
      System.out.println("\nBinary Search :  "); // sorted array is needed
      int low = 0 , high = n-1 , mid;
      
      while(low<=high) {
         mid = low + (high-low)/2;
         if(arr[mid] == key){
               System.out.println("Element "+key +" found at pos "+ (mid+1) );
               return;
            }
         else if(arr[mid] > key){
                 high = mid-1;
         }
         else{
            low = mid + 1;
         }
         }
         System.out.println("Element not found !!!"); 
       }
       
      //  binary Search Application to get the target ,
      //  if not then get the pos where element can be placed
       public int binarySearchApp(int[] arr , int n , int key){
         System.out.println("\nBinary Search Application :  "); // sorted array is needed
         int low = 0 , high = n-1 , mid;
         
         while(low<=high) {
            mid = low + (high-low)/2;
            if(arr[mid] == key){ 
                  return mid;
               }
            else if(arr[mid] > key){
                    high = mid-1;
            }
            else{
               low = mid + 1;
            }
            }
            return low; // not high ? think of one element in arr , try to insert next smaller , larger 
          }

     public static void main(String[] args) {
        int[] arr = new int[] {1,4,6,8,12,34,56};
        Searching obj = new Searching();
        obj.linearSearch(arr, 7, 4);
        obj.binarySearch(arr, 7, 34);
        int res = obj.binarySearchApp(arr, 7, 7);
        System.out.println("Element at position : "+ res);

         
     }
}
