import java.util.Arrays;

public class InitializeTest {
     static int a;
	public static void main(String[] args) {
		int[] local;
		int alocal;
//		System.out.println(local[0]);
//		System.out.println(instance[0]);
//	s	System.out.println(alocal);
		System.out.println(a);

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InitializeTest other = (InitializeTest) obj;
		if (a != other.a)
			return false;
		return true;
	}
	}
