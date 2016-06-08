package com.kong.learning.acm;
/**
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * return 4
 * 找出矩阵中所有1组成的区域
 * @author kong
 *
 */
public class DP {

	public int maximalSquare(char[][] matrix) {
		// dp equation: if(matrix[i][j] != 0) dp[i,j] = min{dp[i-1,j],
		// dp[i,j-1], dp[i-1,j-1]} + 1; else dp[i,j] = 0
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		// 1227
		int[][] dp = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				max = Math.max(max, dp[i][0]);
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == '1') {
				dp[0][j] = 1;
				max = Math.max(max, dp[0][j]);
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max * max;
	}
}
