
public class MergeSortedArrays {
	
	public static void mergeSortedArrays(Integer[] A, int[] B){
		int i = 0;
		while(i<A.length && A[i]!=null){
			if(A[i]>B[0]){
				int temp = B[0];
				int j=1;
				while(j<B.length && B[j]<A[i]){
					B[j-1]=B[j];
					j++;
				}
				B[j-1] = A[i];
				A[i] = temp;
			}
			i++;
		}
		int j = 0;
		while(j<B.length){
			A[i] = B[j];
			i++;j++;
		}
	}

	public static void main(String[] args) {
          Integer[] A = new Integer[]{0,2,6,9,10};
          int[] B = new int[]{1,3,4,5,7,8, 11};
          Integer[] C = new Integer[12];
          System.arraycopy(A, 0, C, 0, 5);
          int i = 0;
          while(i<C.length){
        	  System.out.print(C[i]+",");
        	  i++;
          }
          System.out.println("After merging");
          mergeSortedArrays(C, B);
          i=0;
          while(i<C.length){
        	  System.out.print(C[i]+",");
        	  i++;
          }
          
	}

}
