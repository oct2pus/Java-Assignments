/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackcalculator;

import java.util.LinkedList;

/**
 *
 * @author Austin LaBerta
 */
public class StackCalculator {
	
	private LinkedList<Double> stack;
	
	public StackCalculator() {
		stack = new LinkedList<>();
	}

	public double pop() {
		if(!stack.isEmpty())
			return stack.pop();
		else
			return 0;
	}
	
	public double add() {
		double result,
			   value1,
			   value2;
		if(stack.size() >= 2) {
			value1 = pop();
			value2 = pop();
			result = value1 + value2;
			push(result);
		} else {
			result = 0;
		}

		return result;
	}
	
	public double subtract() {
		double result,
			   value1,
			   value2;
		if(stack.size() >= 2) {
			value1 = pop();
			value2 = pop();
			result = value1 - value2;
			push(result);
		} else {
			result = 0;
		}

		return result;
	}
	
	public double multiply() {
		double result,
			   value1,
			   value2;
		if(stack.size() >= 2) {
			value1 = pop();
			value2 = pop();
			result = value1 * value2;
			push(result);
		} else {
			result = 0;
		}

		return result;
	}
	
	public double divide() {
		double result,
			   value1,
			   value2;
		if(stack.size() >= 2) {
			value1 = pop();
			value2 = pop();
			result = value1 / value2;
			push(result);
		} else {
			result = 0;
		}

		return result;		
	}
	
	public double[] getValues() {
		double[] result = new double[size()];
		for (int x = 0; x < size(); x++) {
			result[x] = (double) stack.get(x);
		}
		return result;
	}
	
	public int size() { 
		return stack.size();
	}
	
	public void push(double x) {
		stack.push(x);
	}
	
	public void clear() {
		stack.clear();
	}
	
}
