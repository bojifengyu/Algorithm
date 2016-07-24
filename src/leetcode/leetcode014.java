package leetcode;

public class leetcode014 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] abc = {"abcdef", "abcd", "abce"};
		System.out.println(leetcode014.longestCommonPrefix(abc));
	}
    public static String longestCommonPrefix(String[] strs) {
    	int len = strs.length;
    	String longPrefix = "";    	
    	if(len > 0){
    		longPrefix = strs[0];
    	}
    	for(int i = 1; i < len; i++){    
    		int minLen = longPrefix.length() > strs[i].length() ? strs[i].length() : longPrefix.length();
    		for(int j = 0; j < minLen; j++){
    			if(longPrefix.charAt(j) != strs[i].charAt(j)){
    				if(longPrefix.length() > j){
    					longPrefix = strs[i].substring(0, j);
    				}
    				break;
    			}
    		}
			if(longPrefix.length() > strs[i].length()){
				longPrefix = strs[i];
			} 
    	}
        return longPrefix;
    }
}