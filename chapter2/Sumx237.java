/**
 * 给定一个N个整数的集合S和另一个整数x，确定S中存在两个其和刚好为x的元素
 * 算法导论第三版P39 2.3-7
 */

package chapter2;

import java.util.Random;
import java.util.Scanner;

public class Sumx237 {

	static int[] temp;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int len = sc.nextInt();
		
		int[] S = new int[len];
		int[] W = new int[len];
		temp = new int[len];
		
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0;i<len;i++){
			int a = rand.nextInt(1000)+1;
			S[i] = a;
			W[i] = x-a;
		}

		MergeSort(S,0,S.length-1);
		MergeSort(W,0,W.length-1);
		boolean flag = FindSumx(S,W,x);
		System.out.println(flag);
		
	}

	private static boolean FindSumx(int[] s, int[] w,int x) {
		
		int len = w.length;
		
		int i=0,j=0;
		
		while(i<len&&j<len){
			if(s[i]==w[j]){
				if(s[i] == x/2 && i<len-1 && j<len-1 && s[i+1] != w[j+1]){
					continue;
				}else{
					System.out.println(s[i]);
					return true;
				}
			}else if(s[i]<w[j]){
				i++;
			}else{
				j++;
			}
		}
		
		return false;
	}

	private static void MergeSort(int[] a, int p, int q) {
		
		if(p<q){
			int mid = (p+q)/2;
			MergeSort(a,p,mid);
			MergeSort(a,mid+1,q);
			Merge(a,p,mid,q);
		}
		
	}

	private static void Merge(int[] a, int p,int mid, int q) {
		
		int i=p,j=mid+1;
		int k=0;
		
		while(i<=mid&&j<=q){
			if(a[i]<a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		
		while(i<=mid){
			temp[k++] = a[i++];
		}
		
		while(j<=q){
			temp[k++] = a[j++];
		}
		
		for(int h=0;h<k;h++){
			a[p+h] = temp[h];
		}
		
	}

}
