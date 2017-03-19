package dynamicprogramming;

import java.util.*;

/*
 * 求最长公共子序列
 * 
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String s =in.next();
			String t =in.next();
			
			
			int[][] res = new int[s.length()+1][t.length()+1];
			int[][] state = new int[s.length()+1][t.length()+1];
			lcsLength(s,t,res,state);
			System.out.println(res[s.length()][t.length()]);
			printLCS(s,state,s.length(),t.length());
		}

	}

	private static void lcsLength(String s,String t,int[][] res,int[][] state){ 
		int slen=s.length();
		int tlen=t.length();
		
		for(int i=1;i<=slen;i++){
			res[i][0]=0;
		}
		for(int i=1;i<=tlen;i++){
			res[0][i]=0;
		}
		
		for(int i=1;i<=slen;i++){
			for(int j=1;j<=tlen;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					res[i][j]=res[i-1][j-1]+1;
					state[i][j]=0;
				}
				else if(res[i-1][j]>=res[i][j-1]){
					res[i][j]=res[i-1][j];
					state[i][j]=1;
				}
				else if(res[i-1][j]<res[i][j-1]){
					res[i][j]=res[i][j-1];
					state[i][j]=2;
				}
				
			}
		}
		
	}
	
	private static void printLCS(String s,int[][] state,int i,int j){
		if(i==0 || j==0) return ;
		if(state[i][j]==0){
			printLCS(s, state, i-1, j-1);
			System.out.print(s.charAt(i-1)+" ");
		}
		else if(state[i][j]==1){
			printLCS(s, state, i-1, j);
		}
		else if(state[i][j]==2){
			printLCS(s, state, i, j-1);
		}
	}
}
