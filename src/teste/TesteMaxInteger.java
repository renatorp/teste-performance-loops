package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TesteMaxInteger {

	public static final void main(final String[] arguments) {
		TimeLogger logger = TimeLogger.getInstance();
		final List<Integer> list = createList();

		for (int j = 0; j < 10; j++) {

			logger.log("Foreach loop", () -> foreachLoop(list));

			logger.log("Iterator foreach", () -> iteratorForeach(list));

			logger.log("Foreach stream", () -> foreachStream(list));

			logger.log("Loop for", () -> loopFor(list));

			System.out.println();
		}
	}

	private static List<Integer> createList() {
		final List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5000000; i++) {
			Random random = new Random();
			list.add(random.nextInt(1000000));
		}
		return list;
	}

	private static void foreachStream(final List<Integer> list) {
		list.stream().max(Integer::max);
	}

	private static void loopFor(final List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++)
			max = Integer.max(max, list.get(i));
	}

	private static void iteratorForeach(final List<Integer> list) {
		// list.forEach(Integer::max);
	}

	private static void foreachLoop(final List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (final Integer s : list)
			max = Integer.max(max, s);
	}

}
