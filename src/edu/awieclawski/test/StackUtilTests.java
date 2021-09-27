package edu.awieclawski.test;

import java.util.Stack;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.model.Address;
import edu.awieclawski.model.JobContract;
import edu.awieclawski.model.Person;
import edu.awieclawski.util.StackUtils;

public class StackUtilTests {

	private static void printStack(BaseEntity entity) {
		Stack<BaseEntity> stack = StackUtils.getStackEntitiesToSave(entity);
		int count = 0;

		System.out.println("\n * Order of peeking from the Stack *");

		count = 0;

		while (!stack.isEmpty()) {
			System.out.println(count + ",stack.peek()=" + stack.peek());
			stack.pop();
			count++;
		}
		System.out.println("The Stack is empty? " + stack.isEmpty());

	}

	public static void main(String[] args) {

		printStack(new JobContract());
		printStack(new Person());
		printStack(new Address());

	}

}
