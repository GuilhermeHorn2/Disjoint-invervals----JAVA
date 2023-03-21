package misc;

public class main_misc {

	public static void main(String[] args) {
		//
	int [][] v = {{1,2},{2,10},{4,6}};
   /* quickSort(v,0,v.length-1);
    for(int i = 0;i < v.length;i++) {
    	for(int j = 0;j < v[i].length;j++) {
    		System.out.print(v[i][j]);
    	}
    	System.out.println();
    }*/
	System.out.println(max_disj(v));

	
		

	}
	//idea 2:instead of trying each interval and check how much disjoint can be formed
	//choose the interval that ends earlier so that you will get more disjoint intervals
	//find the interval that ends earlier so that i dont have to test all the possibilities
	
    private static void swap(int[][]v,int i,int j) {
    	int a = v[i][1];
    	int b = v[i][0];
    	v[i][1] = v[j][1];
    	v[i][0] = v[j][0];
    	v[j][1] = a;
    	v[j][0] = b;
    }
    private static void quickSort(int[][]v,int strt,int end){
    	//
    	if(strt >= end) {
    		return;
    	}
    	int p = v[end][1];
    	int l = strt;
    	int r = end;
    	
    	while(l < r) {
    		while(v[l][1] <= p && l < r) {
    			l++;
    		}
    		while(v[r][1] >= p && l < r) {
    			r--;
    		}
    		swap(v,l,end);
    	}
    	if(v[l][1] > v[end][1]) {
    		swap(v,l,end);
    		}
    	else {
    		l = end;
    	}
    	quickSort(v,strt,l-1);
    	quickSort(v,l+1,end);
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
	private static int max_disj(int[][]v) {
		//
		int s = 0;
		quickSort(v,0,v.length-1);
		//now that i now that the first interval is the right choice 1 for loop is enough
		for(int i = 0;i < v.length;i++) {
			if(is_disjoint(v[0],v[i]) == 1) {
				s++;
			}
		}
		return s+1;
	}
	
	
}
