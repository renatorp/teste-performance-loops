package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

import ch.lambdaj.Lambda;

public class TesteMaxInteger {

	public static final void main(final String[] arguments) {
		TimeLogger logger = TimeLogger.getInstance();
		
		final List<Integer> list = logger.log("createList", TesteMaxInteger::createList);
		
		ImmutableList<Integer> immutableECList = logger.log("convertToECList",() -> convertToECList(list));
		
		List<Integer> ecList = logger.log("castToList", immutableECList::castToList);
		
		System.out.println();
		for (int j = 0; j < 10; j++) {

			logger.log("Foreach loop", () -> foreachLoop(list));

			// logger.log("Iterator foreach", () -> iteratorForeach(list));

			logger.log("Foreach stream", () -> foreachStream(list));

			logger.log("Loop for", () -> loopFor(list));
			
			logger.log("Loop lambdaj", () -> foreachLambdaj(list));

			logger.log("EC Foreach loop", () -> foreachLoop(ecList));

			logger.log("EC Foreach stream", () -> foreachStream(ecList));

			logger.log("EC Loop for", () -> loopFor(ecList));
			
			logger.log("EC Loop lambdaj", () -> foreachLambdaj(ecList));
			
			logger.log("EC immutable loop", () -> loopEC(immutableECList));

			System.out.println();
		}
	}

	private static ImmutableList<Integer> convertToECList(final List<Integer> list) {
		return Lists.immutable.ofAll(list);
	}

	private static List<Integer> createList() {
		final List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
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
		
	}

	private static void foreachLoop(final List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (final Integer s : list)
			max = Integer.max(max, s);
	}

	private static void foreachLambdaj(final List<Integer> list) {
		Lambda.selectMax(list,Lambda.on(Integer.class));
	}
	
	private static void loopEC(ImmutableList<Integer> immutableECList) {
		immutableECList.max();
	}
}
