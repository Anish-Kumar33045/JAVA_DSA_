
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// trees non linear , hierarchial data structure 

public class Trees {

    private TreeNode root; // it should be above Treenode class why?

    private class TreeNode{
        private  int data ; // generic type
        private TreeNode right ;
        private TreeNode left;

        public TreeNode(int data){
            this.data = data;
        }


    }

   

    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void inorder(TreeNode root){
        if(root == null){
            
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // preoder traversal of tree using stacks 
     public void preorderStack(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data +" ");

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }
        }
     }

     // inoder traversal of tree using stacks 
    public void inorderStack(TreeNode root){
        if(root == null){
            return;
        }

       Stack<TreeNode> stack = new Stack<>();
       TreeNode temp = root;

       while(!stack.isEmpty() || temp != null){
           if(temp !=null){
            stack.push(temp);
            temp=temp.left;
           }
           else{
            temp = stack.pop();
             System.out.print(temp.data + " ");
             temp = temp.right;
           }
       }
        }
    

    // postorder traversal of tree using stacks
     public void postorderStack(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.isEmpty() ){
             if(current!= null ){
                  stack.push(current);
                  current = current.left;
             }
             else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else{
                    current = temp;
                }
             }
        }

        
     }

     //  level order traversal of binary tree
        //  traverse level by level 

        public void levelOrder(){
            if(root == null){
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.print(temp.data + " ");
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
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
    public static void main(String[] args) {
        Trees obj = new Trees();

        obj.createBinaryTree();

        System.out.print("\nLevel order traversal : ");
        obj.levelOrder();
        System.out.print("\nInorder traversal     : ");
        obj.inorder(obj.root);
        System.out.print("\nPostorder traversal   : ");
        obj.postorder(obj.root);
        System.out.print("\nPreorder traversal    : ");
        obj.preorder(obj.root);

        System.out.print("\nInorder stack traversal     : ");
        obj.inorderStack(obj.root);
        System.out.print("\nPostorder stack traversal   : ");
        obj.postorderStack(obj.root);
        System.out.print("\nPreorder stack traversal    : ");
        obj.preorderStack(obj.root);

    }
}
