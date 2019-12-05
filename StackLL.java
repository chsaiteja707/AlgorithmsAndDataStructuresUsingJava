/* 
    ---------------------
    stack applications
    ---------------------
    # used in undo mechanism in text editor
    # reverse a string
    # to check balance of paranthesis
    # infix to post fix
    # infix to prefix
    # topoligical sorting
    # Dfs 
    # tower of hannoi
    # tree traversal
    # evaluation of post fix expression
    
    ---------------
    complexity
    ---------------
    #Time Complexity - O(1)
    #Space Complexity - O(1)
    #for creating stack - O(1)
    
*/

import java.io.*;
class Node{
    int value;
    Node link;
    Node(int value, Node link){
        this.value=value;
        this.link=link;
    }
}
class StackLL{
    static Node top=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        while(true){
            System.out.println();
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Display");
            System.out.println("4.Peek");
            System.out.println("5.Quit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1: 
                    push();
                    break;
                case 2: 
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    peek();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();  
        }
    }
    
    public static void push() throws Exception{
        System.out.println("Enter the number to push");
        int n=Integer.parseInt(br.readLine());
        Node temp=new Node(n,null);
        temp.link=top;    
        top=temp;
    }
    
    public static void pop(){
        Node temp=top;
        if(isEmpty())
            System.out.println("Stack is empty");
        else{
            temp=top;
            System.out.println("Element we are deleting : "+temp.value);
            top=top.link;
            temp.link=null;
            temp=null;
        }   
    }
    
     public static void display(){
         Node temp=top;
         if(isEmpty())
             System.out.println("Stack is empty");
        else{
            while(temp!=null){
                System.out.println(temp.value);
                System.out.println("^");
                temp=temp.link;
            }
        }  
    }
    
    public static void peek(){
        Node temp=top;
        if(isEmpty())
             System.out.println("Stack is empty");
        else{
            System.out.println("The top value : "+temp.value);
        }
        
    }
    
    public static boolean isEmpty(){
        if(top==null)
            return true;
        else
            return false;
    }
}