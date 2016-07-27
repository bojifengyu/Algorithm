package data_structure;

public class KMP {  
    public static void main(String[] args) {  
        String s = "aaabaaaabaaaabaaaab"; // 主串  
        String t = "aaaab"; // 模式串  
        char[] ss = s.toCharArray();  
        char[] tt = t.toCharArray();  
        System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串  
        All_KMP_Index(ss,tt);
    }  
  
    /** 
     * 获得字符串的next函数值 
     *  
     * @param t 
     *            字符串 
     * @return next函数值 
     */  
    public static int[] next(char[] t) {  
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                next[i] = j;
            }
            else {  
                j = next[j];  
            }  
        }  
        return next;  
    }  
  
    /** 
     * https://tekmarathon.com/2013/05/14/algorithm-to-find-substring-in-a-string-kmp-algorithm/
     * 
     * KMP匹配字符串 
     *  
     * @param s 
     *            主串 
     * @param t 
     *            模式串 
     * @return 若匹配成功，返回下标，否则返回-1 
     */  
    public static int KMP_Index(char[] s, char[] t) {
        int i = 0;  
        int j = 0;    
        int[] next = next(t);  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } 
        else  
            return i - t.length; // 返回模式串在主串中的头下标  
    }
    public static void All_KMP_Index(char[] s, char[] t) {
        int i = 0;  
        int j = 0;    
        int[] next = next(t);  
        while (i <= s.length - 1) {  
            while (j >= 0 && s[i] != t[j]) {  
                j = next[j];  
            } 
            i++;  
            j++;  
            if(j == t.length){
                System.out.println("在下标：" + (i - t.length) + "处找到substring"); // 返回模式串在主串中的头下标
                j = next[j - 1];
            }
        }
    }
}  