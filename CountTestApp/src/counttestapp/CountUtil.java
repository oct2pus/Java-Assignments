package counttestapp;

/**
 *
 * @author Austin LaBerta
 */
public class CountUtil {
	public static void count(Countable c, int maxCount)
	{
		for(int x = 0; x < maxCount; x++)
		{
			c.incrementCount();
			
			System.out.println(c.getCountString());
			
		}
		
		c.resetCount();

	}
}
