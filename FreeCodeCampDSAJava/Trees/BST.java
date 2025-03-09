
import java.util.Scanner;


// left child data  < parent node
// right child data > parent node

public class BST {

    private TreeNode root;

    private class TreeNode{
        private int data; 
        private TreeNode left;
        private TreeNode right;

        public TreeNode (int data){
            this.data = data;
        }  
    }

    // insert data in BST 

    public void insert (int value){
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root , int value ){
        if(root == null){
            root= new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert (root.left, value );
        }
        else{
            root.right = insert (root.right , value );
        }
        return root;
      }


      // search an element in binary search tree
      public  TreeNode search(int key){
        return search(root, key);
      }

      public TreeNode search(TreeNode root , int key){
        if(root == null || root.data == key){
               return root;
        }
        if(key<root.data){
            return search (root.left , key);
        }
        else{
            return search (root.right , key);
        }
      }

    //   inorder traversal
    public void inorder (TreeNode root){
          if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
          }
    }

    //  finding BST is valid or not 
    boolean isValid (TreeNode root, long min , long max){
        if(root==null){
            return true;
        }
        // min < root.val < max actually in BST
        if(root.data <=min || root.data >= max){
            return false;
        }

        boolean left = isValid(root.left , min, root.data);
        if(left){
            boolean right = isValid(root.right, root.data , max);
            return right;
        }
        return false;
    }
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    BST bst = new BST();
    bst.insert(4);
    bst.insert(3);
    bst.insert(5);
    bst.insert(6);
    bst.insert(2);
    bst.insert(1);

    bst.inorder(bst.root);
    System.out.print("\nEnter the value to searched : ");
    int key = scanner.nextInt();
    if( bst.search(key)!= null){
        System.out.println("\n key found !!! ");    
    }
    else{
        System.out.println("key Not found !!!");
    }
   } 
}
