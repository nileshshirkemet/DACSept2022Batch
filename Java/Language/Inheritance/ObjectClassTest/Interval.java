//A class defined without a super-class implicitly extends java.lang.Object
//which is the root type for all reference types in Java
class Interval {

	private int min;
	private int sec;

	public Interval(int m, int s) {
		min = m + s / 60;
		sec = s % 60; 
	}

	public int minutes() {
		return min;
	}

	public int seconds() {
		return sec;
	}

	public int time() {
		return 60 * min + sec;
	}

	//overriding toString method of java.lang.Object to return
	//the string representation of this object
	public String toString() {
		if(sec < 10)
			return min + ":0" + sec;
		return min + ":" + sec;
	}

	//overriding hashCode method of java.lang.Object to return 
	//an integer obtained from the fields of this object so that
	//same integer is returned by it for other object with matching
	//field values
	public int hashCode() {
		return min + sec;
	}

	//overriding equals method of java.lang.Object to return true
	//if and only if the state of this object matches with the state
	//of other object passed as argument
	public boolean equals(Object other) {
		if(other instanceof Interval) {
			Interval that = (Interval)other; //explicit down-casting
			return (this.min == that.min) && (this.sec == that.sec);
		}
		return false;
	}
}

