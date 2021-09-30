package edu.awieclawski.test;

import java.util.Stack;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.model.Address;
import edu.awieclawski.model.JobContract;
import edu.awieclawski.model.Person;
import edu.awieclawski.service.Pair;
import edu.awieclawski.util.PersistOrderUtils;

public class StackUtilTests {

	private static void printStack(BaseEntity entity) {
		Stack<BaseEntity> stack = PersistOrderUtils.getPersistEntitiesStack(entity);

		int count = 0;

		System.out.println("\n * Order of peeking from the Stack *");

		while (!stack.isEmpty()) {
			System.out.println(count + ",stack.peek()=" + stack.peek());
			stack.pop();
			count++;
		}
		System.out.println("The Stack is empty? " + stack.isEmpty());

	}

	private static void printStackPairsStatic(BaseEntity entity) {
		Stack<Pair> stackedEnts = PersistOrderUtils.getPersistPairsStack(entity);
		int count = 0;

		System.out.println("\n * Order of peeking from the Stack Pairs - static method *");

		System.out.println("map to string" + stackedEnts.toString());

		while (!stackedEnts.isEmpty()) {
			System.out.println(count + ",stack.peek()=" + stackedEnts.peek());
			stackedEnts.pop();
			count++;
		}
		System.out.println("The Stack is empty? " + stackedEnts.isEmpty());

	}

	public static void main(String[] args) {

//		printStack(new JobContract());

//		printStack(new Person());
//		printStack(new Address());

//		printStackMap(new Person());
//		printStackMap(new Address());

		printStackPairsStatic(new JobContract());

		printStackPairsStatic(new JobContract());

		printStackPairsStatic(new Person());

		printStackPairsStatic(new Address());

	}

}
