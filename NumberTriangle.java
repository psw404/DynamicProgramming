package dynamicprogramming;

public class NumberTriangle {

	/*
	 * ����һ�����������Σ��ҵ��Ӷ������ײ�����С·���͡�
	 * ÿһ�������ƶ�������һ�е����������ϡ�
	 * ���磬�����������������Σ�
		
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
	 * �Ӷ����ײ�����С·����Ϊ11 ( 2 + 3 + 5 + 1 = 11)��
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
