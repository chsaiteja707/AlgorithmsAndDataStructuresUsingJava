import java.io.*;

class Node{
    int data;
    Node llink;
    Node rlink;
    Node(Node llink, int data, Node rlink){
        this.data=data;
        this.llink=llink;
        this.rlink=rlink;
    }
}

class TreeTraversals{
    static Node root=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        while(true){
            System.out.println("1.Insert");
            System.out.println("2.Inorder Display");
            System.out.println("3.Preorder Display");
            System.out.println("4.Postorder Display");
            System.out.println("5.peek");
            System.out.println("6.display");
            System.out.println("7.Exit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1:
                    root=insert();
                    break;
                case 2:
                    Node temp1=root;
                    System.out.print("Inorder traversal : ");
                    inOrderDisplay(temp1);
                    break;
                case 3:
                    Node temp2=root;
                    System.out.print("Preorder traversal : ");
                    preOrderDisplay(temp2);
                    break;
                case 4:
                    Node temp3=root;
                    System.out.print("Postorder traversal : ");
                    postOrderDisplay(temp3);
                    break;
                case 5:
                    peek();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
        
    }
    
    public static Node insert() throws Exception{
        System.out.println("Enter value");
        int value=Integer.parseInt(br.readLine());
        if(value==-1)
            return null;
        else{
            System.out.println("Enter left child value for : "+value);
            Node lnode=insert();
            System.out.println("Enter right child value for : "+value);
            Node rnode=insert();  
            return new Node(lnode,value,rnode);
        }    
    }
    
    public static void inOrderDisplay(Node temp){
        if(temp==null){
            System.out.print("");
        }
        else{
            //System.out.println("parent node : "+temp.value);
            //System.out.println("left node for : "+temp.value+" : "+);
            //System.out.println("right node for : "+temp.value+" : "+); 
            inOrderDisplay(temp.llink);
            System.out.print(temp.data+" ");
            inOrderDisplay(temp.rlink);         
        }   
    }
    
    public static void preOrderDisplay(Node temp){
        if(temp==null){
            System.out.print("");
        }
        else{
            //System.out.println("parent node : "+temp.value);
            //System.out.println("left node for : "+temp.value+" : "+);
            //System.out.println("right node for : "+temp.value+" : "+); 
            System.out.print(temp.data+" ");
            preOrderDisplay(temp.llink);
            preOrderDisplay(temp.rlink);         
        }   
    }
    
    public static void postOrderDisplay(Node temp){
        if(temp==null){
            System.out.print("");
        }
        else{
            //System.out.println("parent node : "+temp.value);
            //System.out.println("left node for : "+temp.value+" : "+);
            //System.out.println("right node for : "+temp.value+" : "+); 
            postOrderDisplay(temp.llink);
            postOrderDisplay(temp.rlink);  
            System.out.print(temp.data+" ");
        }   
    }
    
    public static void peek(){
        
    }
    public static void display(){
        
    }
    public static boolean isEmpty(){
       return true;
    }
}