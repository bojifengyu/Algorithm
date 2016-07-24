package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class leetcode015 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
//		int[] nums1 = {-4, -1, -1, 0, 1, 2};
		System.out.println(leetcode015.threeSum(nums));
	}
    public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listlist = new LinkedList<List<Integer>>();
    	int len = nums.length;
    	Arrays.sort(nums); 
    	if(len < 3){
    		return listlist;
    	}
    	for(int l = 0, h  = len - 1; (h > l) && (nums[l] <= 0) && (nums[h] >= 0);){
    		int flag = 0;
    		int goal = 0 - nums[h] - nums[l];
    		int low = l + 1, high = h - 1;
			if((l > 0) && (nums[l] == nums[l - 1])){
				l++;
				continue;
			}
    		while (low <= high){
    			int mid = (high - low) / 2 + low;
    			if(nums[mid] > goal){
    				high = mid -1;
    			}
    			else if(nums[mid] < goal){
    				low = mid + 1;
    			}
    			else{
    		    	List<Integer> test = new LinkedList<Integer>();
    		    	List<Integer> test1 = new LinkedList<Integer>();
    				test.add(nums[l]);
    				test.add(nums[mid]);
    				test.add(nums[h]);
    				flag = 1;
    				if(listlist.size() >= 1){
    					test1 = listlist.get(listlist.size() - 1);
        				if((test.get(0) == test1.get(0)) && ((test.get(1) == test1.get(1)))){
        					break;
        				}
    				}
    				listlist.add(test);
    				break;
    			}
    		}
    		h--;
    		if(nums[h] < 0){
    			h = len - 1;  
    			l++;
    		}
    		else{
    			if(flag == 1){
    				l++;
        			h = len - 1;  
        		}
    		}
    	}
		return listlist;  
    }
}
/*    	if(listlist.size() >= 2){
for(int i = 0; i < listlist.size() - 1; i++){
	List<Integer> test1 = new LinkedList<Integer>();
	List<Integer> test2 = new LinkedList<Integer>();
	test1 = listlist.get(i);
	test2 = listlist.get(i + 1);
	if((test1.get(0) == test2.get(0)) && ((test1.get(1) == test2.get(1)))){
		listlist.remove(test2);
		i--;
	}
}
}*/