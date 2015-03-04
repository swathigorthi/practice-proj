package math;

import java.util.Arrays;
import java.util.List;

public class MathMain {

	public static void main(String[] args) {
//		int m = 131;
//		Map<Integer, Integer> map = MathUtil.primeFactorize(m);
//		for(Integer i : map.keySet()){
//			System.out.println(i +"-"+map.get(i));
//		}
		
		List<List<Integer>> list = MathUtil.nChooseK(Arrays.asList(1,2,3),2);
		for(List<Integer> nl:list){
			System.out.println(nl.toString());
		}

	}

}
