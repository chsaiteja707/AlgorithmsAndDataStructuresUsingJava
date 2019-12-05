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
    #for creating stack - O(n)
    
*/

import java.io.*;
class StackArr{
    static int top=-1;
    static int st[];
    static int n=0;
    public static void main(String A[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Stack size");
        n=Integer.parseInt(br.readLine());
        st=new int[n];
        while(true){
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Peek");
            System.out.println("4.display");
            System.out.println("5.Exit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1:
                    System.out.println("Enter the value to be pushed");
                    int k=Integer.parseInt(br.readLine());
                    push(k);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
        
    }
    
    public static void push(int k){
        if(!isFull()){
            top++;
            st[top]=k;
        }
        else
            System.out.println("Stack is over flow");
        
        
    }
    public static void pop(){
        if(isEmpty())
            System.out.println("Stack is under flow");
        else
            top--;
        
    }
    public static void peek(){
        if(isEmpty())
            System.out.println("Stack is under flow");
        else
            System.out.println("Peek element : "+st[top]);
        
    }
    public static void display(){
        if(isEmpty())
            System.out.println("Stack is under flow");
        else
            for(int i=0;i<=top;i++)
                System.out.println("-->"+st[i]);
    }
    public static boolean isEmpty(){
        if(top==-1)
            return true;
        else
            return false;
        
    }
    
    public static boolean isFull(){
        if(top>=n-1)
            return true;
        else
            return false;
        
    }
}