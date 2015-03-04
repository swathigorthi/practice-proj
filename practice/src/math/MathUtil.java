package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathUtil {
//	public static int getLCD(int a, int b){
//		int c=0;
//		int m = Math.max(a, b);
//		int n = Math.min(a, b);
//		Map<Integer, Integer> primeFactorMap = primeFactorize(m);
//		
//		
//		
//		return c;
//	}
//	
	public static Map<Integer, Integer> primeFactorize(int m){
		Map<Integer, Integer> map = new HashMap<>();
		int i=2;
		while(i<=Math.sqrt(Integer.valueOf(m).doubleValue())){
			while(m%i==0){
				if(map.containsKey(i)){
					int n = map.get(i)+1;
					map.put(i, n);
				}
				else{
					map.put(i, 1);
				}
				m=m/i;
			}
		    i++;
		}
		if(m!=1){
			map.put(m, 1);
		}
		return map;
	}
	
	public static List<List<Integer>> nChooseK(List<Integer> list,  int k){
		List<List<Integer>> allComb = new ArrayList<>();
		int size = list.size();
		if(k==1){
			for(Integer i :list){
				List<Integer> nl = Arrays.asList(i);
				allComb.add(nl);
			}
		}
		else if (k==size){
			allComb.add(list);
		}
		else{
			for(int i=0;i<size;i++){
				List<Integer> sl = list.subList(i+1, size);
				int newSize = sl.size();
				if(newSize<k-1){
					break;
				}
				for(List<Integer> subList : nChooseK(sl, k-1)){
					List<Integer> nl = new ArrayList<>();
					nl.add(list.get(i));
					nl.addAll(subList);
					allComb.add(nl);
				}
			}
		}
		return allComb;
	}
	
	

}
