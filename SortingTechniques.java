
public class SortTechniques {
	public static void display(int a[],int n) {
		for(int k:a)
			System.out.print(k+"\t");
	}
	
	public void selectionSort(int a[], int n) {
		for(int i=0;i<n;i++) {
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			if(min!=i) {
				int temp=a[min];
				a[min]=a[i];
				a[i]=temp;
				
			}
		}
		display(a, n);
		
	}
	
	public void insertionSort(int a[], int n) {
		for(int i=1;i<n;i++) {
			int temp=a[i];
			int j=i-1;
			while(j>=0&&a[j]>temp) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		display(a,n);
	}
	public static void main(String[] args) {
		int a[]= {3,4,5,2,1};
		int n=5;
		SortTechniques ob=new SortTechniques();
		System.out.print("SelectionSort : ");
		ob.selectionSort(a,n);
		System.out.println();
		System.out.print("InsertionSort : ");
		int b[]= {3,4,5,2,1};
		ob.insertionSort(b,n);
        System.out.println();
	}

}
