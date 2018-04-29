
package counttestapp;

/**
 *
 * @author Austin LaBerta
 */
public class CountTestApp {
	public static void main(String[] args)
	{
		System.out.print("Counting alligators...\n\n");
		
		Alligator al = new Alligator();
		Sheep blackie = new Sheep("Blackie"),
			  dollie = null;
		CountUtil.count(al, 3);
		
		System.out.print("\nCounting sheep...\n\n");
		CountUtil.count(blackie, 2);
		
		System.out.print("\n");
		
		dollie = (Sheep) blackie.cloned("dolly");
		CountUtil.count(dollie, 3);
		System.out.print("\n");

		CountUtil.count(blackie, 1);
	}
}
