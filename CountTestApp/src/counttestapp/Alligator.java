package counttestapp;

/**
 *
 * @author Austin LaBerta
 */
public class Alligator implements Countable {
	
	// private
	private int count;
	
	// public
	public Alligator()
	{
		count = 0;
	}
	
	@Override
	public void incrementCount()
	{
		count += 1;
	}
	
	@Override
	public void resetCount()
	{
		count = 0;
	}
	
	@Override
	public int getCount()
	{
		return count;
	}
	
	@Override
	public String getCountString()
	{
		
		return getCount() + " alligator";
	}
}
