package dynamicprogramming;

/*
 * 最大连续序列和
 */
public class LagestContinuousSequenceSum {

	public static void main(String[] args) {
		
		int[] data={-2,11,-4,13,5,-6,7,-5,2};
		int[] state =new int[data.length];

		System.out.println(calSum(data,state));
	}
	
	private static int calSum(int[] data,int[] state){
		int max=0;
		int sum=0;
		for(int i=0;i<data.length;i++){
			sum+=data[i];
			if(sum>max){
				max=sum;
			}
			if(sum<0){
				sum=0;
			}
			
		}
		return max;
	}
	
	private static void print(int[] state,int max){
		for(int i=0;i<state.length;i++){
		}
	}
}
