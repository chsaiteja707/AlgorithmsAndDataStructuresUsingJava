

import java.io.*;

class Qnode{
	Tnode tnode;
	Qnode link;
	public Qnode(Tnode tnode) {
		this.tnode=tnode;
		this.link=null;
	}
}

class Tnode{
    Tnode llink;
    int value;
    Tnode rlink;
    Tnode(int  value){
        this.llink=null;
        this.value=value;
        this.rlink=null;
    }
}

class BSTRec{
    static Tnode root=null;
    static Qnode head=null;
	static Qnode tail=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        while(true){
            Tnode c=root;
            int value;
            System.out.println(" 1.Insert");
            System.out.println(" 2.InOrder Display");
            System.out.println(" 3.Search");
            System.out.println(" 4.Empty Tree");
            System.out.println(" 5.Level order diplay");
            System.out.println(" 6.Pre order diplay");
            System.out.println(" 7.Post order diplay");
            System.out.println(" 8.Count nodes");
            System.out.println(" 9.Tree height");
            System.out.println("10.Inorder Predecessor");
            System.out.println("11.Inorder Successor");
            System.out.println("12.Delete element");
            System.out.println("13.Exit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1:  
                    System.out.println("Enter value");
                    value=Integer.parseInt(br.readLine());
                    root=insert(c,value);
                    break;
                case 2:
                    if(c==null)
                    System.out.println("Tree is empty");
                    inorderDisplay(c);
                    break;
                case 3:
                    System.out.println("Enter value");
                    value=Integer.parseInt(br.readLine());
                    if(search(c,value)!=null)
                        System.out.println("Value : "+value+" is found"); 
                    else
                        System.out.println("Value : "+value+" is not found");
                    break;
                case 4: 
                    root=null;
                    System.out.println("Tree is Emptied");
                    break;
                case 5:
                    if(root!=null)
                    	levelOrderDisplay(c);
                    else
                    	System.out.println("Tree is empty");
                    break;
                case 6:
                    if(root!=null)
                    	preOrderDisplay(c);
                    else
                    	System.out.println("Tree is empty");
                    break;
                case 7:
                    if(root!=null)
                    	postOrderDisplay(c);
                    else
                    	System.out.println("Tree is empty");
                    break;
                case 8: 
                    System.out.println("Node count : "+countNodes(c));
                    break;
                case 9: 
                    System.out.println("Tree height : "+treeHeight(c));
                    break;
                case 10: 
                    if(c!=null&&c.llink!=null)
                        System.out.println("Inorder Predessor : "+inorderPredecessor(c).value);
                    else
                        System.out.println("Root node doesn't have predecessor");
                    break;
                case 11: 
                    if(c!=null&&c.rlink!=null)
                        System.out.println("Inorder Successor : "+inorderSuccessor(c).value);
                    else
                        System.out.println("Root node doesn't have successor");
                    break;
                 case 12:  
                    System.out.println("Enter value");
                    value=Integer.parseInt(br.readLine());
                    root=delete(c,value);
                    break;
                
                case 13:
                	System.exit(1);
               
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }  
    }
    
    public static Tnode delete(Tnode c, int value) {
    	if(c==null)
    		return null;
    	else if(c.value==value&&c.rlink==null&&c.llink==null)
    		return null;
    	else if(c.value==value&&(c.rlink==null)) {
    		return c.llink;
    	}
		else if(c.value==value&&(c.llink==null)) {
		    return c.rlink;
		}
		else if(c.value==value&&c.rlink!=null&&c.llink!=null) {
			Tnode temp;
			System.out.println("llink height : "+treeHeight(c.llink));
			System.out.println("rlink height : "+treeHeight(c.rlink));
			if(treeHeight(c.llink)>treeHeight(c.rlink)) {
				
				temp=inorderPredecessor(c);
				System.out.println("value of pre : "+temp.value);
				c.value=temp.value;
				c.llink=delete(c.llink,temp.value);
			}
			else {
				temp=inorderSuccessor(c);
				System.out.println("value of suc"+c.value);
				c.value=temp.value;
				c.rlink=delete(c.rlink, temp.value);
			}
			return c;
		}
		else if(value>c.value)
    		c.rlink=delete(c.rlink,value);
    	else if(value<c.value)
    		c.llink=delete(c.llink, value);
    	return c;
    }
    
    public static void levelOrderDisplay(Tnode p){
    	enqueue(p);
        while(!queueIsEmpty()){
            if(head.tnode.llink!=null)
                enqueue(head.tnode.llink);
            if(head.tnode.rlink!=null)
                enqueue(head.tnode.rlink);
            dequeue();
        }
    }
    
    public static void enqueue(Tnode p) {
        Qnode temp=new Qnode(p);
    	if(queueIsEmpty()) {
    		head=temp;
        	tail=temp;
        	System.out.print("-->"+p.value);
    	}
    	else {
    		System.out.print("-->"+p.value);
    		tail.link=temp;
    		tail=temp;
    	}
    }
    
    public static void dequeue() {
    	if(queueIsEmpty())
            System.out.println("Queue is empty");
    	else
            head=head.link;	
    }
    
    public static boolean queueIsEmpty() {
    	if(head==null||tail==null)
    		return true;
    	else 
    		return false;
    }
    
    public static Tnode insert(Tnode p, int value){	
    	if(p==null)
    		return new Tnode(value);
    	else if(value<p.value)
    		p.llink=insert(p.llink,value);
    	else if(value>p.value)
    		p.rlink=insert(p.rlink, value);
    	return p;	
    }
    
    public static void inorderDisplay(Tnode p){
        if(p!=null){
            inorderDisplay(p.llink);
            System.out.print("->"+p.value);
            inorderDisplay(p.rlink);   
        }
    }
    
    public static void preOrderDisplay(Tnode p){
        if(p!=null) {
            System.out.print("->"+p.value);
            preOrderDisplay(p.llink);
            preOrderDisplay(p.rlink);         
        }   
    }
    
    public static void postOrderDisplay(Tnode p){
        if(p!=null) {
            postOrderDisplay(p.llink);
            postOrderDisplay(p.rlink);  
            System.out.print("->"+p.value);
        }   
    }
    
    public static Tnode search(Tnode p, int value){
        if(p==null)
            return p;
        else if(value==p.value)
            p=new Tnode(value);
        else if(value<p.value)
            p=search(p.llink,value);
        else if(value>p.value)
            p=search(p.rlink,value);
        return p;
    }
    
    public static int countNodes(Tnode p){
        if(p==null)
            return 0;
        else{
            int x=countNodes(p.llink);
            int y=countNodes(p.rlink);
            return x+y+1;
        }     
    }
    
    public static int treeHeight(Tnode p){
        if(p==null)
            return 1;
        else{
            int x=countNodes(p.llink);
            int y=countNodes(p.rlink);
            if(x>y)
                return x;
            else 
                return y;
        }
    }
    
    public static Tnode inorderPredecessor(Tnode p){
    	p=p.llink;
    	while(p.rlink!=null)
    		p=p.rlink;
    	return p;
    }
    
    public static Tnode inorderSuccessor(Tnode p){
    	p=p.rlink;
    	while(p.llink!=null)
    		p=p.llink;
    	return p;
    }
}