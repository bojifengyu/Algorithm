package leetcode;

public class leetcode003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution003 s = new Solution003();
		System.out.println(s.lengthOfLongestSubstring("c"));
	}
}

class Solution003 {
    public int lengthOfLongestSubstring(String s) {
    	int count = 0, max = 0, len = s.length(), firstindex = 0, findindex = 0;
    	for(int i = 0; i < len; i++){
    		findindex = s.indexOf(s.charAt(i), firstindex);
    		if(findindex == i){
    			count++;    			
    		}
    		else if(findindex < i){
    			count = i - findindex;
    			firstindex = findindex + 1 ;
    			
    		}
    		if(max < count){
    			max = count;
    		}
    	}
		return max;        
    }
}