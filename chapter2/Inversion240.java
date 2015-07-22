/**
 * A[1..n]是一个数组，定义若i<j且A[i]>A[j]，则为逆序对，求任意给定数组的逆序对
 * 算法导论第三版P24 2-4
 */

package chapter2;

import java.util.Scanner;

public class Inversion240 {

	
	static int[] L,R;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		L = new int[n];
		R = new int[n];
		
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		
		int count = CountInversion(a,0,n-1);
		
		System.out.println(count);
		
	}

	private static int CountInversion(int[] a, int p, int q) {
		
		int c = 0;
		
		if(p<q){
			int mid = (p+q)/2;
			c+=CountInversion(a,p,mid);
			c+=CountInversion(a,mid+1,q);
			c+=MergeInversion(a,p,mid,q);
		}
		return c;
		
	}

	private static int MergeInversion(int[] a, int p, int mid, int q) {
		
		int c = 0;
		
		int i = 0,j = 0;
		
		int llen = mid-p+1,rlen = q-mid;
		
		for(int k=0;k<llen;k++){
			L[k] = a[p+k];
		}
		
		for(int k=0;k<rlen;k++){
			R[k] = a[mid+1+k];
		}
		
		int k=p;
		while(i<llen&&j<rlen){
			if(L[i]>R[j]){
				c += llen-i;
				a[k++] = R[j++];
			}else{
				a[k++] = L[i++];
			}
		}
		
		while(i<llen){
			a[k++] = L[i++];
		}
		
		while(j<rlen){
			a[k++] = R[j++];
		}
		
		return c;
		
	}

}
