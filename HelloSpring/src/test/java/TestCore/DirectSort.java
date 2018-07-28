package TestCore;

import org.junit.Test;

public class DirectSort {
	@Test
	public void ds(){
		int[] a={24,16,45,97,62,33,88,44,90};
		
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for (j = i-1; j >=0; j--) {
				if(a[j]>temp){
					a[j+1]=a[j];
				}else{
					break;
				}
			}
			a[j+1]=temp;
		}
		
		for (int i : a) {
			System.out.println(i+",");
		}
	}

}
