package TestCore;

import org.junit.Test;

public class ChaRu {
	@Test
    public  void anChaRu() {
    	int[] arr={49,38,65,97,76,13,27,49,78,34,12,64,1};
    	
        if (arr == null || arr.length == 0)
            return;

        for (int i = 1; i < arr.length; i++) {// 假设第一个数的位置是正确的，要想往后移，就必须要假设第一个数的位置是正确的。

            int j = i;
            int target = arr[i];// 等待插入数字

            // 后移数字
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 插入数字
            arr[j] = target;
        }
        
        for (int i : arr) {
			System.out.println(i+",");
		}
    }
}