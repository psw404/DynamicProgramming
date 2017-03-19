package dynamicprogramming;
import java.util.*;

/*
 * 01±≥∞¸Œ Ã‚
 * 
 */
public class OneZerobagQuestion {

	public static void main(String[] args) {
		int value[] ={0,8,10,4,5,5};
		int weight[]={0,6,4,2,4,3};
		int n=5;
		int v=10;
		int[][] dp =new int[n+1][v+1];
		int k= countMostValue(value,weight,n,v,dp);
		System.out.println(k);
		print(value, weight, n, v, dp);
	}

	private static int countMostValue(int[] value, int[] weight, int n,int v,int[][] dp) {
		for(int i=1;i<=n;i++){
			for(int j=1;j<=v;j++){
				if(j>=weight[i]){
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j-weight[i]]+value[i]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][v];
	}
	
	private static void print(int[] value,int[] weight,int n,int v,int[][] dp){
		int j=v;
		int[] x =new int[n+1];
		for(int i=n;i>0;i--){
			if(dp[i][j]>dp[i-1][j]){
				x[i]=1;
				j-=weight[i];
			}
		}
		
		for(int i=1;i<=n;i++){
			if(x[i]==1)
				System.out.print(value[i]+" ");
		}
		
	}

}
