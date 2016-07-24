package leetcode;

public class leetcode001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution001 s = new Solution001();
		int[] a = new int[]{0,4,3,0};
		a = s.twoSum(a, 0);
		for(int aa : a){
			System.out.println(aa);			
		}
	}
}
class Solution001 {
    public int[] twoSum(int[] nums, int target) {
//        int min = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
        	for(int j = i + 1; j <nums.length; j++){
        		if(nums[i] + nums[j] == target){
        			return new int[]{i,j}; 
        		}
        	}
        }
        return new int[]{0,0};
    }
}