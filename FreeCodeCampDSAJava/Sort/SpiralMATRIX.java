package FreeCodeCampDSAJava.Sort;


public class SpiralMATRIX {
    public void spiral (int[][] arr , int r ,int c){
      int i, k=0,l=0;
      while(k<r && l<c){

        for(i = l ; i < c ; i++){
            System.out.print(arr[k][i]+" ");
        }
        k++;

        for(i = k ; i<r ; i++) {
            System.out.print(arr[i][c-1]+" ");
        }
        c--;
        
        if(k < r){
            for(i = c-1; i >= l ; i--){
                System.out.print(arr[r-1][i]+" ");
            }
            r--;
        }

        if(l < c){
            for(i=r-1 ; i>=k ; i--){
                System.out.print(arr[i][l]+" ");
            }
            l++;
        }
      }
    }

   public static void main(String[] args) {
     int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,0,10,11,},{12,13,14,15}};
      SpiralMATRIX obj = new SpiralMATRIX();
      for (int i = 0; i < 4; i++) {
          for(int j =0; j<4 ; j++){
            System.out.print(arr[i][j]+" ");
          }
      }
      System.out.println();
     obj.spiral(arr,4,4);

   }   
}
 