
public class MyInteger {
  private int value;
  
  public MyInteger(){};
  
  public MyInteger(int value){
	   this.value = value;
  }
  
  public int getValue(){
	  return value;
  }
  
  

@Override
public int hashCode() {
	return 1;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MyInteger other = (MyInteger) obj;
	if (value != other.value)
		return false;
	return true;
}
}
