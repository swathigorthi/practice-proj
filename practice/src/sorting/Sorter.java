package sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
	public static List<Integer> radixSort(List<Integer> inputList){
		int m = 10;
		int n= 1;
		int size = inputList.size();
		List<List<Integer>> radixBucketList = new ArrayList<>();
		List<Integer> outputList = new ArrayList<>();
		outputList.addAll(inputList);
		boolean flag = true;
		for(int i =0;i<10;i++){
			List<Integer> l = new ArrayList<>();
			radixBucketList.add(l);
		}
		while(flag){
			for(Integer i: outputList){
				int rem = i%m;
				int bucket = rem/n;
				radixBucketList.get(bucket).add(i);
			}
			outputList.clear();
			for(List<Integer> eachBucket :radixBucketList ){
				if(eachBucket.size() == size){
					flag = false;
				}
				outputList.addAll(eachBucket);
				eachBucket.clear();
			}
			m=m*10;
			n=n*10;
		}
		return outputList;
	}
}
