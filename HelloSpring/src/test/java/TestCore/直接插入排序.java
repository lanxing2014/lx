package TestCore;

import org.junit.Test;

public class 直接插入排序 {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            /*for (j = i-1; j>=0 && a[j]>temp; j--) {
                //将大于temp的往后移动一位
                a[j+1] = a[j];
            }*/
            for (j = i-1; j>=0; j--) {
                //将大于temp的往后移动一位
                if(a[j]>temp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            System.out.println();
            System.out.println(j); 
            a[j+1] = temp;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public int[] directS(int[] arr){
    	if(arr==null || arr.length == 0){
    		return arr;
    	}
    	for (int i = 1; i < arr.length; i++) {
			int j=i;
			int target = arr[i];
			while(j>0 && target < arr[j-1]){
				arr[j]=arr[j-1];
				j--;
			}
			arr[j] =target;
		}
    	
		return arr;
    } 
    
    @Test
    public void tt(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
    	int[] b =directS(a);
    	for (int i : b) {
			System.out.print(i+",");
		}
    	
    }
}