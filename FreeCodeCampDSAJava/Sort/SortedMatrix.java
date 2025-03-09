package FreeCodeCampDSAJava.Sort;

// each row sorted 
// each col sorted 

public class SortedMatrix {
     public void search(int[][] matrix , int n, int x){
        int i = 0;
        int j = n-1; // searching from top right corner

        while(i<n && j>=0){
            if(matrix[i][j] == x){
                System.out.println("x foumd at : "+i+", "+j);
                return;
            }
            if(matrix[i][j] > x){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("Not found");
     }


    public static void main(String[] args) {
        SortedMatrix obj = new SortedMatrix();
        int[][] matrix = new int[][] {{10,20,30,40} ,{15,25,35,45},{27,29,37,48},{32,33,39,51}};
        obj.search(matrix, 4, 32);
    }
}
