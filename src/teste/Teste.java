package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teste {

	public static final void main(final String[] arguments) {
		
		TimeLogger logger = TimeLogger.getInstance();
		final List<String> list = createList();
		
		for (int j = 0; j < 10; j++) {

			logger.log("Foreach loop", () -> foreachLoop(list));

			logger.log("Iterator foreach", () -> iteratorForeach(list));

			logger.log("Foreach stream", () -> foreachStream(list));

			logger.log("Loop for", () -> loopFor(list));

			System.out.println();
		}
	}

	private static List<String> createList() {
		final List<String> list = new ArrayList<>();
		for (int i = 0; i < 5000000; i++)
			list.add(UUID.randomUUID().toString());
		return list;
	}

	private static void foreachStream(final List<String> list) {
		list.stream().forEach(String::length);
	}

	private static void loopFor(final List<String> list) {
		for (int i = 0; i < list.size(); i++)
			list.get(i).length();
	}

	private static void iteratorForeach(final List<String> list) {
		list.forEach(String::length);
	}

	private static void foreachLoop(final List<String> list) {
		for (final String s : list)
			s.length();
	}

}
