package counttestapp;

/**
 *
 * @author Austin LaBerta
 */
public class Sheep implements Countable, Cloneable {
	
	// private
	private int count;
	private final String name;
	
	// public
	public Sheep()
	{
		count = 0;
		name = "sheep";
	}
	
	public Sheep(String name)
	{
		count = 0;
		this.name = name;
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
		return getCount() + " " + name;
	}
	
	// Same Name
	@Override
	public Cloneable cloned()
	{
		return new Sheep(name);
	}

	// Assigned Name
	@Override
	public Cloneable cloned(String name)
	{
		return new Sheep(name);
	}
}
