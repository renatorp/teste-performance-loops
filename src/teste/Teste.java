package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

public class Teste {

	public static final void main(final String[] arguments) {
		
		TimeLogger logger = TimeLogger.getInstance();
		
		final List<String> list = logger.log("createList", Teste::createList);
		
		ImmutableList<String> immutableECList = logger.log("convertToECList", ()->convertToECList(list));
		
		List<String> ecList = logger.log("convertToECList.castToList()", () -> immutableECList.castToList());
		
		System.out.println();
		for (int j = 0; j < 10; j++) {

			logger.log("Foreach loop", () -> foreachLoop(list));

			logger.log("Iterator foreach", () -> iteratorForeach(list));

			logger.log("Foreach stream", () -> foreachStream(list));

			logger.log("Loop for", () -> loopFor(list));
			
			logger.log("EC Foreach loop", () -> foreachLoop(ecList));

			logger.log("EC Iterator foreach", () -> iteratorForeach(ecList));

			logger.log("EC Foreach stream", () -> foreachStream(ecList));

			logger.log("EC Loop for", () -> loopFor(ecList));
			
			logger.log("EC immutable loop", () -> loopEC(immutableECList));
			
			System.out.println();
		}
	}

	private static List<String> createList() {
		final List<String> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++)
			list.add(UUID.randomUUID().toString());
		return list;
	}

	private static ImmutableList<String> convertToECList(List<String> list) {
		return Lists.immutable.ofAll(list);
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

	private static void loopEC(ImmutableList<String> immutableECList) {
		immutableECList.forEach(String::length);;
	}
}
