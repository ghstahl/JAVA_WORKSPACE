package recursion;

public class Cordinates {
	public Integer x;
	public Integer y;

	public Cordinates(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Cordinates(Cordinates c) {
		this.x = c.x;
		this.y = c.y;
	}

	public Cordinates clone() {
		return new Cordinates(x, y);
	}

	@Override
	public boolean equals(Object aThat) {
		// check for self-comparison
		if (this == aThat)
			return true;

		// use instanceof instead of getClass here for two reasons
		// 1. if need be, it can match any supertype, and not just one class;
		// 2. it renders an explict check for "that == null" redundant, since
		// it does the check for null already - "null instanceof [type]" always
		// returns false. (See Effective Java by Joshua Bloch.)
		if (!(aThat instanceof Cordinates))
			return false;
		// Alternative to the above line :
		// if ( aThat == null || aThat.getClass() != this.getClass() ) return
		// false;

		// cast to native object is now safe
		Cordinates that = (Cordinates) aThat;

		// now a proper field-by-field evaluation can be made
		return this.x == that.x && this.y == that.y;
	}

}
