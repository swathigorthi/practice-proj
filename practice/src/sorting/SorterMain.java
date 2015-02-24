package sorting;

import java.util.Arrays;
import java.util.List;

public class SorterMain {

	public static void main(String[] args) {
		List<Integer> inputList = Arrays.asList(9,179, 139, 38, 10, 5, 36);
		System.out.println(Sorter.radixSort(inputList).toString());

	}

}
