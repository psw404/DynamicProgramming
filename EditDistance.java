package dynamicprogramming;

import java.util.*;

/*
 * ��С�༭����/�ַ������ƶ�
 * ��������S��T,����֮��ľ��붨��Ϊ���Զ�����һ���м������µĲ���
 * ��1��ɾȥһ���ַ���
 * ��2������һ���ַ�
 * ��3���ı�һ���ַ�
 * û����һ�β�������������1����S��T��Ϊͬһ���ַ�������С������Ϊ���ǵľ��롣������Ӧ���㷨
 */
public class EditDistance {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		while(in.hasNext()){
			String s=in.next();
			String t =in.next();
			int[][] res =new int[s.length()+1][t.length()+1];
			editDistance(res,s,t);
			System.out.println(res[s.length()][t.length()]);
		}

	}
	
	
	private static void editDistance(int[][] res,String s,String t){
		int match=0;
		int insert =1;
		int delete=2;
		int[] opt =new int[3];
		
		for(int i=1;i<res.length;i++)
			res[i][0]=i;
		
		for(int j=1;j<res[0].length;j++)
			res[0][j]=j;
		
		for(int i=1;i<=s.length();i++){
			for(int j=1;j<=t.length();j++){
				
				opt[match]=res[i-1][j-1]+(s.charAt(i-1)==t.charAt(j-1)?0:1);
				opt[insert]=res[i][j-1]+1;
				opt[delete]=res[i-1][j]+1;
				res[i][j]= Math.min(opt[delete],Math.min(opt[match], opt[insert]));
				
			}
		}
		
		int k=goal_cell(res, s, t);
		System.out.println(k);
		System.out.println(k==(s.length()-t.length()));
		
	}
	
	/*
	 * �Ӵ�ƥ��,k==(s.length()-t.length())��t����s���Ӵ���
	 */
	private static int goal_cell(int[][] res,String s,String t){
		int slen =s.length();
		int tlen=t.length();
		int diff=res[slen][0];
		for(int i=1;i<=tlen;i++){
			if(res[slen][i]<diff)
				diff=res[slen][i];
		}
		
		return diff;
		
	}
	

}
