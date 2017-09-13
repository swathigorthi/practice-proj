
public class MergeIntervals {
	
	public static void SortIntervals(Integer[][] input, int start, int last){
        if(start!=last){
			int pos = pivot(input, start, last);
	        if(pos!=last){
	        	Swap(input, pos, last);
	        	SortIntervals(input, 0,pos-1);
	        	SortIntervals(input, pos+1, last);
	        }
        }
	}
	
	public static void Swap(Integer[] input[], int pos1, int pos2){
		Integer[] temp = input[pos1];
		input[pos1] = input[pos2];
		input[pos2] = temp;
	}
	
	public static int pivot(Integer[] input[], int start, int last){
		int pivot = input[last][0];
		int fp= start;
		int lp = last;
		loop:while(fp<last){
			if(input[fp][0]< pivot){
				fp++;
				continue;
			}
			while(input[lp][0]>= pivot){
                 lp--;
                 if(lp==fp){
                	 break loop;
                 }
			}
			Swap(input, fp, lp);
			fp++;
		}
		return fp;
		
	}
	
	public static int MergeIntervals(Integer[] input[], int start, int last){
//		int fp = start;
//		int np = start+1;
//		int rp= np;
//		while(rp<=last){
//			if(input[fp][1]<input[np][0]){
//				fp=np;
//				np++;
//			}
//			else{
//				if(input[fp][1]<input[np][1]){
//					input[fp][1] = input[np][1];
//				}
//				if(input[fp][1]==input[last][1]){
//					break;
//				}
//				if(np!=last){
//					input[np][0] = input[rp+1][0];
//					input[np][1] = input[rp+1][1];
//					rp++;
//				}
//			}
//		}
		
		int i = start;
		int j= i+1;
		while(i<=last-1){
			if(input[i][1]>=input[i+1][0]){
				if(input[i][1]<input[i+1][1]){
					input[i][1]=input[i+1][1];
				}
				j++;
				if(j>last) break;
				input[i+1] = input[j];
			}
			else{
				i++;
				if(i==j) j++;
			}
		}
		return i;
		
	}

	//TODO: can make better
	public static void main(String[] args) {
//		Integer[] input[] = new Integer[][]{{1,2}, {8,12}, {10,13},{9,11},{4,6}, {3,5}};
		Integer[] input[] = new Integer[][]{{1,4}, {3,5}, {4,6},{8,12},{9,11}, {10,13}};
//		for(int i=0;i<input.length;i++){
//			System.out.println(input[i][0]+","+input[i][1]);
//		}
//		SortIntervals(input, 0, input.length-1);
//		for(int i=0;i<input.length;i++){
//			System.out.println(input[i][0]+","+input[i][1]);
//		}
		int last = MergeIntervals(input, 0 , input.length-1);
		for(int i=0;i<=last;i++){
			System.out.println(input[i][0]+","+input[i][1]);
		}
		
	}

}
