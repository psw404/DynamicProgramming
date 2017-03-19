package dynamicprogramming;

import java.util.*;

//假设有几种硬币，如1，3,5 并且数量无限，
//请找出能够组成某个数目的组合方式种数
public class TheKindOfCoinSum {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		while(in.hasNextInt()){
			int n=in.nextInt();
			
			int[] coin ={1,3,5};
			int[] sum = new int[n+1];
			calTheMinimumAmount(coin,sum,n);
			
			System.out.println(sum[n]);
		}
	}
	
	
	private static void calTheMinimumAmount(int[] coin,int[] sum,int n){
		sum[0]=1;
		for(int j=0;j<coin.length;j++){
			for(int i=1;i<=n;i++){
				if(i-coin[j]>=0){
					sum[i]+=sum[i-coin[j]];
				}
			}
		}
		
	}
	
	
}
