package leetcode;

public class leetcode009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leetcode009.isPalindrome(1021201));
	}
    public static boolean isPalindrome(int x) {
		int s = 0, i = 10;
		if(x == 0){
	        return true;			
		}
    	if(x < 0 || x % 10 == 0){
    		return false;
    	}
    	else{
    		while(x >= i){
    			s = x;
    			while(s >= i){
    				s = s / 10;
    			}
    			if((s % 10) != (x % 10)){
    				return false;
    			}
				i = i * 10;
    			x = x / 10;
    		}
    	}
        return true;
    }
}