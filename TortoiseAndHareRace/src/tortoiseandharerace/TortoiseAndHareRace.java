package tortoiseandharerace;

/**
 *
 * @author Austin LaBerta
 */
public class TortoiseAndHareRace {

	public static void main(String[] args) {
		RunnerThread tortoise = new RunnerThread("Tortoise", 10, 0),
					 hare = new RunnerThread("Hare", 100, 90);
		
		tortoise.start();
		hare.start();
	}
	
}
