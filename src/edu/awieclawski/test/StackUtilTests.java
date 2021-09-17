package edu.awieclawski.test;

import java.util.Stack;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.model.JobContract;
import edu.awieclawski.util.StackUtils;

public class StackUtilTests {

	public static void main(String[] args) {

		JobContract jobCtr = new JobContract();

		System.out.println("stack from " + jobCtr.getEntityHeaderName() + "--");

		Stack<BaseEntity> stack = StackUtils.getStackEntitiesToSave(jobCtr);

		int count = 0;
		for (BaseEntity obj : stack) {
			System.out.println(count + ",obj=" + obj);
			count++;
		}

		System.out.println("\n");

		count = 0;

		while (!stack.isEmpty()) {
			System.out.println(count + ",stack.peek()=" + stack.peek());
			stack.pop();
			count++;
		}
		System.out.println("The Stack is " + stack);

	}

}
