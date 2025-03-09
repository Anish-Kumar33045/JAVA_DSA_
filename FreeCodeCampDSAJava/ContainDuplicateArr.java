import java.util.HashSet;
import java.util.Set;

public class ContainDuplicateArr {
    public boolean containsDuplicate(int[] arr){
        for(int i = 0 ; i<arr.length - 1; i++){
           for(int j=i+1; j<arr.length; j++){
            if(arr[i] == arr[j]){
                return true;
            }
           }
        }
        return false;
    }

    boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]); // the elements are added to set , on iterating 
            // and arr[i] number is already in set set then duplicate exist
        }
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicateArr obj = new ContainDuplicateArr();
        int[] arr = new int[] {1,2,3,4,1};
        System.out.println(obj.containsDuplicate(arr));
        System.out.println(obj.containsDuplicate2(arr));
    }
}
