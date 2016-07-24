package leetcode;

public class leetcode004 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution004 s = new Solution004();
		int[] nums1 = new int[]{1, 2, 3}, nums2 = new int[]{4, 5};
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}

class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1 = nums1.length, len2 = nums2.length;
    	int sum_len = len1 + len2;
    	int flag = sum_len % 2;//标记数组元素数量之和是奇数还是偶数，0表示偶数，1表示奇数
    	if((len1 == 0) || (len2 == 0)){
    		if((flag == 0)){
    			if((len1 == 0)){
    				return (nums2[(len2 / 2) - 1] + nums2[len2 / 2]) / 2.0;
    			}
    			else{
    				return (nums1[(len1 / 2) - 1] + nums1[len1 / 2]) / 2.0;
    			}
    		}
    		else{
    			if((len1 == 0)){
    				return (nums2[len2 / 2]);
    			}
    			else{
    				return (nums1[len1 / 2]);
    			}   			
    		}
    	}
    	int i = 0, j = 0;
    	int mid1 = 0, mid2 = 0;
    	for(; (i < len1) && (j < len2);){
    		if(nums1[i] < nums2[j]){
    			if(i + j == ((len1 + len2) / 2 -1)){
    				mid1 = nums1[i];
    			}
    			if(i + j == ((len1 + len2) / 2)){
    				mid2 = nums1[i];
    			}
    			i++;
    		}
    		else{    			
    			if(i + j == ((len1 + len2) / 2 -1)){
    				mid1 = nums2[j];
    			}
    			if(i + j == ((len1 + len2) / 2)){
    				mid2 = nums2[j];
    			}
    			j++;
    		}
    	} 
    	while(i < len1){
			if(i + j == ((len1 + len2) / 2 -1)){
				mid1 = nums1[i];
			}
			if(i + j == ((len1 + len2) / 2)){
				mid2 = nums1[i];
			}
			i++;    		
    	}
    	while(j < len2){			
			if(i + j == ((len1 + len2) / 2 -1)){
				mid1 = nums2[j];
			}
			if(i + j == ((len1 + len2) / 2)){
				mid2 = nums2[j];
			}
			j++;    		
    	}
    	if((flag == 0)){
    		return ((mid1 + mid2) / 2.0);       		
    	}     
    	else{
    		return mid2;
    	}
    }
}