package misc;

public class main_misc {

	public static void main(String[] args) {
		//
		int[][] v = {{1,2},{2,10},{4,6},{7,8}};
		System.out.println(max_dis(v));
		
		
     
}
	private static int is_disjoint(int[]v,int[]l){
		//Given 2 intervals check if they are disjoint or no
		if(v[0] >= l[0] && v[0] <= l[1] || v[1] >= l[0] && v[1] <= l[1]){
			//not disjoint
			return 0;
		}
		//disjoint
		return 1;
	}
	private static int max_dis(int[][]v) {
		//
		int r = 0;
		for(int i = 0;i < v.length;i++){
			int s = 0;
			for(int j = 0;j < v.length;j++) {
				if(i != j){
					if(is_disjoint(v[i],v[j]) == 1) {
						s++;
						if(s >= r) {
							r = s;
						}
					}
				}
			}
		}
		return r+1;
	}
	
}
