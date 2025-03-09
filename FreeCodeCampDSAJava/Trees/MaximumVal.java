

public class MaximumVal {

        private TreeNode root; // it should be above Treenode class why?
    
        private class TreeNode{
            private  int data ; // generic type
            private TreeNode right ;
            private TreeNode left;
    
            public TreeNode(int data){
                this.data = data;
            }
    
        }


public void createBinaryTree() {
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);
    TreeNode sixth = new TreeNode(6);
    TreeNode seventh = new TreeNode(7);

     root = first;
    first.left = second;
    first.right = third;
    second.left=fourth;
    second.right=fifth;
    third.left=sixth;
    third.right=seventh;

  }
 
  public int findMax(){
    return findMax(root);
  }
  public int findMax(TreeNode root){
      if(root == null){
        return Integer.MIN_VALUE;
      }

      int result = root.data;
      int left = findMax(root.left);
      int right = findMax(root.right);

      if(left > result){
        result = left ;
      }
      if(right > result){
        result = right ;
      }

      return result;
  }

public static void main(String[] args) {
  MaximumVal obj = new MaximumVal();
  obj.createBinaryTree();
//   System.out.println("Maximum value : " + obj.findMax(obj.root));

// instead of passing obj.root we can also do as by function : 
System.out.println("Maximum value : " + obj.findMax());
}

}

