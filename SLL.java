import java.io.*;
class Node{
    int data;
    Node link;
    Node(int data,Node link){
        this.data=data;
        this.link=link;
    }
}


class SLL{
    static Node root=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        
        int ch;
        while(true){
            System.out.println("1.Append");
            System.out.println("2.Display");
            System.out.println("3.Count elements");
            System.out.println("4.Quit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1: append();
                        break;
                case 2: display();
                    break;
                case 3: count();
                    break;
                case 4: System.exit(1);
                    
                default: System.out.println("Invalid Choice");
            }
        }
    }
    public static void display(){
        Node temp=root;
        if(temp==null)
            System.out.println("List is empty");
        else{
            while(temp!=null){
                System.out.print("-->"+temp.data);
                temp=temp.link;
            }
            System.out.println();     
        }
        System.out.println();
    }
    
    public static void append() throws Exception{
        System.out.println("Enter the node data to append: ");
        int n=Integer.parseInt(br.readLine());
        Node temp =new Node(n,null);
        if(root==null)
            root=temp;
        else{
            Node p=root;
            while(p.link!=null)
                p=p.link;
            p.link=temp;
        } 
        System.out.println();
    }
    
    public static void count() throws Exception{
        Node temp=root;
        int count=1;
        if(root==null){
            count=0;
        }
        else{
             while(temp.link!=null){
            temp=temp.link;
            count++;
             }  
        }    
        System.out.println("count : "+count);
        System.out.println();
    }
}