import java.io.*;
class QueueArr{
    static int head=0;
    static int tail=0;
    static int que[];
    static int n=0;
    public static void main(String A[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Queue size");
        n=Integer.parseInt(br.readLine());
        que=new int[n];
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
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            que[tail]=k;
            tail++;
        }       
    }
    
    public static void dequeue(){
        if(isEmpty())
            System.out.println("Queue is Empty");
        else{
            for(int i=head;i<=tail&&i+1<n;i++)
                que[i]=que[i+1];
            tail--;
        }
        
    }
    
    public static void display(){
        if(isEmpty())
            System.out.println("Queue is empty");
        else
            for(int i=head;i<tail;i++)
                System.out.println("-->"+que[i]);
    }
    public static boolean isEmpty(){
        if(head==tail)
            return true;
        else
            return false;
        
    }
    
    public static boolean isFull(){
        if(tail==n)
            return true;
        else
            return false;
        
    }
}
