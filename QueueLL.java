import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node{
	int value;
	Node link;
	Node(int value, Node link){
		this.value=value;
		this.link=link;
	}
}

public class QueueLL {
    static Node head=null;
    static Node tail=null;
    public static void main(String A[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.display");
            System.out.println("4.Exit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1:
                    System.out.println("Enter the value to be enqueued");
                    int k=Integer.parseInt(br.readLine());
                    enqueue(k);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
        
    }
    
    public static void enqueue(int k){
    	Node temp=new Node(k,null);
    	if(isEmpty()) {
    		head=temp;
    		tail=temp;
    	}
    	else {
    		tail.link=temp;
            tail=temp;
    	}      
    }
    
    public static void dequeue(){
    	
    	Node temp=tail;
        if(isEmpty())
            System.out.println("Queue is Empty");
        else{
            head=head.link;
        }
        
    }
    
    public static void display(){
        if(isEmpty())
            System.out.println("Queue is Empty");
        else {
        	Node temp=head;
        	while(temp!=null) {
        		//System.out.println("head value : "+head.value);
        		System.out.println(temp.value);
        		System.out.println("^");
        		temp=temp.link;
        	}   
        }
    }
    public static boolean isEmpty(){
        if(head==null||tail==null)
            return true;
        else
            return false;
        
    }
    
}