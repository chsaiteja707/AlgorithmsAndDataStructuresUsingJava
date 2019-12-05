import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


public class DLL{
    static Node root=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        
        int ch;
        while(true){
            System.out.println("1.Append");
            System.out.println("2.Display");
            System.out.println("3.Count elements");
            System.out.println("4.Remove First element");
            System.out.println("5.Insert element");
            System.out.println("6.Quit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1: append();
                        break;
                case 2: display();
                    break;
                case 3: 
                	if(size()==0)
                		System.out.println("Linked list is empty");
                	else
                		System.out.println("Linked list size : "+size());	
                    break;
                case 4: removeFirstElement();
                	break;
                case 5: insertElement();
            		break;
                case 6: System.exit(1);
                    
                default: System.out.println("Invalid Choice");
            }
        }
    }
    public static void insertElement() throws NumberFormatException, IOException {
        
    	System.out.println("Enter element");
    	int ele=Integer.parseInt(br.readLine());
    	System.out.println("Enter position to insert");
    	int pos=Integer.parseInt(br.readLine());
    	Node temp=new Node(null, ele, null);
        Node p=root;
        //if(size==0)
	}
	public static void removeFirstElement() {
    	if(root==null)
    		System.out.println("Linked list is empty");
    	else 
    		root=root.rlink;	
	}
	public static void display(){
    	if(root==null)
    		System.out.println("Linked list is empty");
    	else {
    		Node temp=root;
    		System.out.print("[Null]-");
    		while(temp!=null) {
    			System.out.print("-[R:"+temp.data+":L]-");
    			temp=temp.rlink;
    		}
    		System.out.println("-[Null]");
    	}
    }
    
    public static void append() throws Exception{
    	System.out.println("Enter the value to append : ");
    	int value=Integer.parseInt(br.readLine());
    	Node temp=new Node(null,value,null);
    	if(root==null)
    		root=temp;
    	else {
    		Node p=root;
    		while(p.rlink!=null)
    			p=p.rlink;
    		p.rlink=temp;
    		temp.llink=p;
    		
    	}   
    }
    
    public static int size(){
    	int count=0;
    	if(root==null)
    		return count;
    	else {
    		
    		Node temp=root;
    		while(temp!=null) {
    			temp=temp.rlink;
    			count++;
    		}
    		return count;
    	}
        
    }
}