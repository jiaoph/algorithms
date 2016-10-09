package nju.software.algorithms;

/**
*BM Algorithm
* @author JiaoPH
* @version 
* 
*/

public class BMAlgorithm {
	public static void main(String[] args){
		BMAlgorithm.pattern("example", "Here is a sample example");
	}
	

	/** 
     * �㷨ƥ�� 
     */  
    public static int pattern(String pattern, String target) {  
        int tLen = target.length();         
        int pLen = pattern.length();          
        if (pLen > tLen) {  
            return -1;  
        }  
  
        int[] bad_table = build_bad_table(pattern);// 1,3,5,6,2,  
        int[] good_table = build_good_table(pattern);// 1,8,5,10,11,12,13  
//        System.out.println(good_table.length);
//        for(int i =0 ;i<good_table.length;i++){
//        	System.out.print(good_table[i]+" ");
//      }
        for (int i = pLen - 1, j; i < tLen;) {  
            System.out.println("��Ծλ�ã�" + i);  
            for (j = pLen - 1; target.charAt(i) == pattern.charAt(j); i--, j--) {  
                if (j == 0) {  
                    System.out.println("ƥ��ɹ���λ�ã�" + i);  
//                  i++;   // ���ƥ��  
//                  break;  
                    return i;  
                }  
            }  
            i += Math.max(good_table[pLen - j - 1], bad_table[target.charAt(i)]);  
        }  
        return -1;  
    }  
  
    /** 
     * �ַ���Ϣ�� 
     */  
    public static int[] build_bad_table(String pattern) {  
        final int table_size = 256;  
        int[] bad_table = new int[table_size];  
        int pLen = pattern.length();  
  
        for (int i = 0; i < bad_table.length; i++) {  
            bad_table[i] = pLen;  //Ĭ�ϳ�ʼ��ȫ��Ϊƥ���ַ�������  
        }  
        for (int i = 0; i < pLen - 1; i++) {  
            int k = pattern.charAt(i);  
            //System.out.println(k);
            bad_table[k] = pLen - 1 - i;  
        }  
//      for (int i : bad_table) {  
//          if (i != 7) {  
//              System.out.print(i + ",");  
//          }  
//      }  
        return bad_table;  
    }  
  
    /** 
     * ƥ��ƫ�Ʊ� 
     * 
     * @param pattern 
     *            ģʽ�� 
     * @return 
     */  
    public static int[] build_good_table(String pattern) {  
        int pLen = pattern.length();  
        int[] good_table = new int[pLen];  
        int lastPrefixPosition = pLen;  
  
        for (int i = pLen - 1; i >= 0; --i) {  
            if (isPrefix(pattern, i + 1)) {  
                lastPrefixPosition = i + 1;  
            }  
            good_table[pLen - 1 - i] = lastPrefixPosition - i + pLen - 1;  
        }  
  
        for (int i = 0; i < pLen - 1; ++i) {  
            int slen = suffixLength(pattern, i);  
            good_table[slen] = pLen - 1 - i + slen;  
        }  
        return good_table;  
    }  
  
    /** 
     * ǰ׺ƥ�� 
     */  
    private static boolean isPrefix(String pattern, int p) {  
        int patternLength = pattern.length();  
        for (int i = p, j = 0; i < patternLength; ++i, ++j) {  
            if (pattern.charAt(i) != pattern.charAt(j)) {  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * ��׺ƥ�� 
     */  
    private static int suffixLength(String pattern, int p) {  
        int pLen = pattern.length();  
        int len = 0;  
        for (int i = p, j = pLen - 1; i >= 0 && pattern.charAt(i) == pattern.charAt(j); i--, j--) {  
            len += 1;  
        }  
        return len;  
    }  
  
}

