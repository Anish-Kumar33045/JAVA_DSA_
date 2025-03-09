public class MergeTwoSortedArr {
     int[] merge(int[] arr1,int[] arr2 ,int n, int m){
        int[] result = new int[n+m];
        int i=0 , j=0 , k = 0;

        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            result[k] = arr1[i];
            i++;k++;
        }

        while(j<m){
            result[k] = arr2[j];
            j++;k++;
        }
        return result; 
     }

     public void printArray(int[] arr){
        for(int i = 0 ; i<arr.length; i++){
          System.out.print(arr[i]+" ");
        }
        System.out.println();
          }

    public static void main(String[] args) {
        MergeTwoSortedArr obj = new MergeTwoSortedArr();

        int[] arr1 = new int[] {1,2,5,8};
        // int[] arr2 = new int[] {3,2,4,9}; //same number wrong o/p
        int[] arr2 = new int[] {3,4,6,9};
        int[] result = new int[8];

       
        System.out.println("array 1:");
        obj.printArray(arr1);
        System.out.println("array 2:");
        obj.printArray(arr2);
        result =  obj.merge(arr1, arr2, 4, 4);
        System.out.println("array merged :");
        obj.printArray(result);
        

    }
}
