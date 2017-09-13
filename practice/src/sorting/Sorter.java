package sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
	
	public static int[] bubbleSort(int[] input, int low, int high){
		if(low >=high){
			return input; 
		}
		int temp = 0; 
		for(int i = low; i < high ; i++){
			if(input[i] > input[i+1]){
			    temp = input[i];
				input[i] = input[i+1];
				input[i+1] = input[i];
			}
		}
		return bubbleSort(input, low, high-1);
	}
	
	public static int[] quickSort(int[] input, int low, int high){
		if(low < high){
			int wall = partition(input, low, high);
			quickSort(input, low, wall);
			quickSort(input, wall+1, high);
		}
		return input; 
	}
	
	private static int partition(int[] input , int low, int high){
		int pivot = input[high];
		int wall = low;
		int temp = 0; 
		for(int i = low; i < high; i++){
			if(input[i] < pivot){
				temp = input[wall];
				input[wall] = input[i];
				input[i] = temp; 
				wall = wall + 1; 
			}
		}
		input[high] = input[wall];
		input[wall] = pivot; 
		return wall; 
	}
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
