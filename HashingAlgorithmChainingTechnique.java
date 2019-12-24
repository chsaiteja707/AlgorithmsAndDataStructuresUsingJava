
import java.io.*;
class Dnode{
    int rem;
    Snode slink;
    Dnode dlink;
    Dnode(Snode slink, int rem){ 
        this.slink=slink;
        this.rem=rem;
        this.dlink=null;
    }
}

class Snode{
    Snode slink;
    int value;
    Snode(int value){
        this.value=value;
        this.slink=null;
    }
}

class HashingAlgorithmChainingTechnique{
    static Dnode droot=null;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String A[]) throws Exception{
        int ch;
        while(true){
        	System.out.println("1.Insert");
            System.out.println("2.Display");
            System.out.println("3.Search");
            System.out.println("4.Quit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(br.readLine());
            switch(ch){
                case 1: 
                	System.out.println("Enter value");
	                int value=Integer.parseInt(br.readLine());
	                int rem=value%10;
	                droot=sortedDnodeInsert(droot,value,rem);
	                break;
                case 2: 
                	
                	display(droot);
                case 3: 
            		System.out.println("Enter value");
	                int value1=Integer.parseInt(br.readLine());
	                int rem1=value1%10;
	                if(search(droot,value1,rem1))
	                	System.out.println("value : "+value1+" is present in key : "+rem1);
	                else
	                	System.out.println("value : "+value1+" is not found");
                    break;
                    
                case 4: System.exit(1);
                    
                default: System.out.println("Invalid Choice");
            }
        }
    }
    
    public static boolean search(Dnode droot,int value,int rem) {
    	if(droot==null)
    		return false;
    	else if(rem==droot.rem) 
    		return isExistingInSnode(droot.slink, value);
    	else if(rem>droot.rem)
    		return search(droot.dlink, value, rem);
    	else 
    		return false;
    }
    
    public static Dnode sortedDnodeInsert(Dnode d,int value,int rem){
        Dnode temp;
        if(d==null) {
        	Snode stemp=sortedSnodeInsert(null, value);
        	temp=new Dnode(stemp, rem);
        }	
        else if(rem==d.rem) {
        	temp=d;
        	temp.slink=sortedSnodeInsert(temp.slink, value);
        }
        else if(rem<d.rem) {
        	System.out.println("here");
        	Snode stemp=sortedSnodeInsert(null, value);
        	temp=new Dnode(stemp, rem);
        	temp.dlink=d;
        }
        else if(rem>d.rem&&d.dlink==null) {
        	temp=d;
        	Snode stemp=sortedSnodeInsert(null, value);
        	temp.dlink=new Dnode(stemp, rem);	
        }
        else if(rem>d.rem&&d.dlink!=null) {
        	temp=d;
        	temp.dlink=sortedDnodeInsert(temp.dlink, value, rem);
        }
        else
        	temp=null;
        return temp;
    }
    
    public static Snode sortedSnodeInsert(Snode p,int value) {
		Snode temp=null;
		if(isEmptySnode(p)) 
			temp= new Snode(value);
		
		else if(value<p.value){
			temp=new Snode(value);
			temp.slink=p;
		}
		
		else if(value>p.value&&p.slink==null) {
			temp=p;
			temp.slink=new Snode(value);
		}
		
        else if(value==p.value) {
			System.out.println("No duplicates are allowed");
			return p;
		}
        
		else if(value>p.value&&p.slink!=null) {
			temp=p;
			temp.slink=sortedSnodeInsert(temp.slink, value);
		}
		return temp;	
	}
    
    public static boolean isExistingInSnode(Snode snode, int value) {
    	if(snode==null)
    		return false;
    	else if(snode.value==value)
    		return true;
    	else if(value>snode.value)
    		return isExistingInSnode(snode.slink, value);
    	else
    		return false;
    	
    }
    
     public static boolean isEmptySnode(Snode snode) {
		if(snode==null)
			return true;
		else
			return false;
	}
    
     public static boolean isEmptyDnode() {
		if(droot==null)
			return true;
		else
			return false;
	}
    
    public static void display(Dnode p){
        if(p!=null){
        	
            System.out.print(p.rem);
            System.out.print("----");
            Snode temp=p.slink;
            
            while(temp!=null){
                System.out.print("-->"+temp.value);
                temp=temp.slink;
            }
            System.out.println();
            display(p.dlink);    
        }
    }
}