package nju.software.algorithms;

/**
* @author JiaoPH
* @version 
* շת�ദ������������������������ӵ��㷨:
* �������������Լ���������н�С���Ǹ���������������������Լ��.
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
