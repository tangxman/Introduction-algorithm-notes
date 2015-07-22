/**
 * πÈ≤¢≈≈–Ú
 */

package chapter2;

public class MergeSort {

	static int[] b;
	
	public static void main(String[] args) {
		
		int[] a = {100,20,526,425,12,451,45,256,15};
		
		int len = a.length;
		
		b = new int[len];
		
		MergeSort(a,0,len-1);
		
		for(int i=0;i<len;i++){
			System.out.print(a[i]+" ");
		}

	}

	private static void MergeSort(int[] a, int p, int q) {
		if(p<q){
			int mid = (p+q)/2;
			
			MergeSort(a,p,mid);
			MergeSort(a,mid+1,q);
			Merge(a,p,mid,q);
		}
		
	}

	private static void Merge(int[] a, int p, int mid, int q) {
		
		int i=p,j=mid+1;
		int k=0;
		while(i<=mid&&j<=q){
			if(a[i]<a[j]){
				b[k++] = a[i++];
			}else{
				b[k++] = a[j++];
			}
		}
		
		while(i<=mid){
			b[k++] = a[i++];
		}
		
		while(j<=q){
			b[k++] = a[j++];
		}
		
		for(int h=0;h<k;h++){
			a[p+h] = b[h];
		}
		
	}

}
