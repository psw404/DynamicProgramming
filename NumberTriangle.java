package dynamicprogramming;

public class NumberTriangle {

	/*
	 * 给定一个数字三角形，找到从顶部到底部的最小路径和。
	 * 每一步可以移动到下面一行的相邻数字上。
	 * 比如，给出下列数字三角形：
		
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
	 * 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
	 */
	public int minimumTotal(int[][] triangle) {
		
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle[n-1][i];
        }
        for (int i = n - 1; i > 0; i--){
            for (int j = i; j >0; j--){
                dp[i-1][j-1] = Math.max(dp[i][j] + triangle[i-1][j-1],
                                        dp[i][j-1] + triangle[i-1][j-1]);
            }
        }
        return dp[0][0];
    }

}
