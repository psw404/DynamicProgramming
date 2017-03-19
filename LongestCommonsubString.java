package dynamicprogramming;

import java.util.*;
public class LongestCommonsubString {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		String s=in.next();
		String t =in.next();
		int n=s.length();
		int m=t.length();
		System.out.println(longestCommonSubString(s, n, t, m));
		

	}
	
	private static int longestCommonSubString(String s,int n,String t,int m){
		int[][] dp =new int[n][m];
		int max=0;
		
		for(int i=0;i<n;i++){
			if(s.charAt(i)==t.charAt(0))
				dp[i][0]=1;
		}
		
		for(int j=0;j<m;j++){
			if(s.charAt(0)==t.charAt(j))
				dp[0][j]=1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(s.charAt(i)==t.charAt(j)){
					dp[i][j]=dp[i-1][j-1]+1;
					max=Math.max(dp[i][j], max);
				}
					
			}
		}
		
		return max;
	}

}
