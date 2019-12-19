
import java.io.*;

class Tnode{
    Tnode llink;
    int value;
    int height;
    Tnode rlink;
    Tnode(int  value){
        this.llink=null;
        this.value=value;
        this.height=1;
        this.rlink=null;
    }
}

class AVLTrees{
    static Tnode root=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        while(true){
            Tnode p=root;
            System.out.println("1.Insert");
            System.out.println("2.InOrder Display");
            System.out.println("3.PreOrder Display");
            System.out.println("4.PostOrder Display");
            System.out.println("5.Tree Height");
            System.out.println("6.Delete node");
            System.out.println("7.Exit");
            int ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1:
                    
                    System.out.println("Enter value");
                    int value=Integer.parseInt(br.readLine());
                    root=insert(p,value);
                    break;
                case 2:
                    inorderDisplay(p);
                    break;
                case 3:
                    preOrderDisplay(p);
                    break;
                case 4:
                    postOrderDisplay(p);
                    break;
                case 5:
                    System.out.println("Height is : "+height(p));
                    break;
                case 6:
                	System.out.println("Enter value");
                    value=Integer.parseInt(br.readLine());
                    if(search(p, value)==null)
                    	System.out.println("Element : "+value+" not found");
                    else
                    	root=delete(p,value);
                    break;
                case 7:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }  
    }
    
     public static void preOrderDisplay(Tnode temp){
        if(temp==null){
            System.out.print("");
        }
        else{
            System.out.print(temp.value+"->");
            preOrderDisplay(temp.llink);
            preOrderDisplay(temp.rlink);         
        }   
    }
    
    public static void postOrderDisplay(Tnode temp){
        if(temp==null){
            System.out.print("");
        }
        else{
            postOrderDisplay(temp.llink);
            postOrderDisplay(temp.rlink);  
            System.out.print(temp.value+"->");
        }   
    }
    
    public static Tnode insert(Tnode p, int value){	
        if(p==null){
            Tnode temp=new Tnode(value);
            return temp;
        }
        else if(value<p.value)
            p.llink=insert(p.llink,value);
        else if(value>p.value)
            p.rlink=insert(p.rlink,value);
        p.height=height(p);
        System.out.println("Height of tree : "+p.value+" = "+p.height);
        System.out.println("balance factor p: "+balanceFactor(p));
        System.out.println("balance factor p.llink: "+balanceFactor(p.llink));
        System.out.println("balance factor p.rlink: "+balanceFactor(p.rlink));
        if     (balanceFactor(p)==-2 && balanceFactor(p.rlink)==-1){
            System.out.println("RR imbalance");
            p=rrImbalance(p);
        }
            
        else if(balanceFactor(p)== 2 && balanceFactor(p.llink)== 1){
            System.out.println("LL imbalance");
            p=llImbalance(p);
        }
            
        else if(balanceFactor(p)== 2 && balanceFactor(p.llink)==-1){
            System.out.println("LR imbalance");
            p=lrImbalance(p);
        }
            
        else if(balanceFactor(p)==-2 && balanceFactor(p.rlink)== 1) {
        	System.out.println("RL imbalance");
            p=rlImbalance(p);
        }
        return p;
    }
    
  //  
    public static Tnode delete(Tnode p, int value){	
        if(p==null)
    		return null;
    	else if(p.value==value&&p.rlink==null&&p.llink==null)
    		return null;
    	else if(p.value==value&&(p.rlink==null)) {
    		return p.llink;
    	}
		else if(p.value==value&&(p.llink==null)) {
		    return p.rlink;
		}
		else if(p.value==value&&p.rlink!=null&&p.llink!=null) {
			Tnode temp;
			System.out.println("llink height : "+height(p.llink));
			System.out.println("rlink height : "+height(p.rlink));
			if(height(p.llink)>height(p.rlink)) {
				
				temp=inorderPredecessor(p);
				System.out.println("value of pre : "+temp.value);
				p.value=temp.value;
				p.llink=delete(p.llink,temp.value);
			}
			else {
				temp=inorderSuccessor(p);
				System.out.println("value of suc"+p.value);
				p.value=temp.value;
				p.rlink=delete(p.rlink, temp.value);
			}
			return p;
		}
        p.height=height(p);
        System.out.println("Height of tree : "+p.value+" = "+p.height);
        System.out.println("balance factor p: "+balanceFactor(p));
        System.out.println("balance factor p.llink: "+balanceFactor(p.llink));
        System.out.println("balance factor p.rlink: "+balanceFactor(p.rlink));
        if     (balanceFactor(p)==-2 && balanceFactor(p.rlink)==-1){
            System.out.println("RR imbalance");
            p=rrImbalance(p);
        }
            
        else if(balanceFactor(p)== 2 && balanceFactor(p.llink)== 1){
            System.out.println("LL imbalance");
            p=llImbalance(p);
        }
            
        else if(balanceFactor(p)== 2 && balanceFactor(p.llink)==-1){
            System.out.println("LR imbalance");
            p=lrImbalance(p);
        }
            
        else if(balanceFactor(p)==-2 && balanceFactor(p.rlink)== 1) {
        	System.out.println("RL imbalance");
            p=rlImbalance(p);
        }
        return p;
    }
   // 
    public static Tnode llImbalance(Tnode p) {Tnode c=p.llink;
        c.rlink=new Tnode(p.value);
        c.height=height(c);
    	return c;
    }
    
    public static Tnode rrImbalance(Tnode p) {
        Tnode c=p.rlink;
        c.llink=new Tnode(p.value);
        c.height=height(c);
    	return c;
    }
    
    public static Tnode rlImbalance(Tnode p) {
    	Tnode pr=p.rlink;
    	Tnode prl=pr.llink;
        Tnode temp=new Tnode(prl.value);
        temp.rlink=pr;
        temp.rlink.llink=prl.rlink;
        temp.llink=p;
        temp.llink.rlink=prl.llink; 
        temp.height=height(temp);
    	return temp;
    }
    
     public static Tnode lrImbalance(Tnode p) {
    	Tnode pl=p.llink;
    	Tnode plr=pl.rlink;
        Tnode temp=new Tnode(plr.value);
        temp.rlink=p;
        temp.rlink.llink=plr.rlink;
        temp.llink=pl;
        temp.llink.rlink=plr.llink;
        temp.height=height(temp);
        return temp;
    }
    
    
    
    public static int balanceFactor(Tnode p){
        if(p==null)
            return 0;
        return(height(p.llink)-height(p.rlink));
    }
    
    public static void inorderDisplay(Tnode p){
        if(p!=null){
            inorderDisplay(p.llink);
            System.out.print("->"+p.value);
            inorderDisplay(p.rlink);   
        }
    }
    
    public static int height(Tnode p){
        if(p==null)
            return 0;
        else if(p.llink==null&&p.rlink==null)
            return 1;
        else{
            if(height(p.llink)>height(p.rlink))
                return height(p.llink)+1;
            else
                return height(p.rlink)+1;
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
    
    public static int countNodes(Tnode p){
        if(p==null)
            return 0;
        else{
            int x=countNodes(p.llink);
            int y=countNodes(p.rlink);
            return x+y+1;
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
}
