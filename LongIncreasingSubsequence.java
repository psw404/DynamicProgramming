package dynamicprogramming;

import java.util.*;

public class LongIncreasingSubsequence {
	public static void main(String[] args) {
			
			Scanner in = new Scanner(System.in);
			List<Integer> list =new ArrayList<>();
			int num;
			while((num=in.nextInt())!=-1){
				list.add(num);
			}
			
			
			int res = lisLength(list);
			System.out.println(res);
	}

	/*
	 * 最长递增子序列
	 */
	private static int lisLength(List<Integer> list) {
		Integer[] arr =new Integer[list.size()];
		list.toArray(arr);
		int[] res =new int[arr.length];
		int max=0;
		for(int i=0;i<arr.length;i++){
			if(res[i]==0) res[i]=1;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]>arr[i]){
					res[j]=Math.max(res[j],res[i]+1);
					max=Math.max(res[j], max);
				}
			}
			
		}
		
		return max;
	}
	
	

}