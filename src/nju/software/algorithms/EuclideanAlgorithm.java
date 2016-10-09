package nju.software.algorithms;

/**
* @author JiaoPH
* @version 
* 辗转相处法：求两个正整数的最大公因子的算法:
* 两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数.
* 
*/

public class EuclideanAlgorithm {
	public static void main(String args[]){
		int result = gcd(319,377);
		System.out.print(result);//29
		
	}
	 public static int gcd(int m,int n){
		 if(m%n==0){
			 return n; 
		 }else{
			 return gcd(n,m%n);
		 }
		 
	 }
	

}
