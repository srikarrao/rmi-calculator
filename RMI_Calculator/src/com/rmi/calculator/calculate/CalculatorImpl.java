package com.rmi.calculator.calculate;

import java.rmi.*;
import java.rmi.server.*;

import com.rmi.calculator.server.Result;

public class CalculatorImpl extends UnicastRemoteObject implements
		CalculatorInterface {

	// regular expressions to check the equation
	public static final String OPR_EXP = "[+\\-*/]+";
	public static String NUMS_EXP = "[0-9]+";

	public CalculatorImpl() throws RemoteException {
		super();
	}

	public Result performCalculation(String equation) {
		Double result = 0.0;
		Result opResult = new Result();
		Double aDouble = 0.0;
		try {
			System.out.println("Equation received: " + equation);
			if (null != equation && !equation.isEmpty()) {
				String[] tokens = equation.split(OPR_EXP);
				String[] numTokens = equation.split(NUMS_EXP);
				if (isNumeric(tokens[0]) == true) {
					result = Double.parseDouble(tokens[0]);
				} else {
					System.out.println("First number " + tokens[0]
							+ " is invalid");
					opResult.setValid(false);
					opResult.setMessage("First number " + tokens[0]
							+ " is invalid");
					return opResult;
				}

				for (int i = 1; i < tokens.length; i++) {
					if (isNumeric(tokens[i]) == true) {
						aDouble = Double.parseDouble(tokens[i]);
					} else {
						System.out.println("The number " + tokens[i]
								+ " is invalid");
						opResult.setValid(false);
						opResult.setMessage("The number " + tokens[i]
								+ " is invalid");
						return opResult;
					}
					/** if-else statements to perform respective calculations **/
					if (numTokens[i].equals("+")) {
						result = result + aDouble;
					} else if (numTokens[i].equals("-")) {
						result = result - aDouble;
					} else if (numTokens[i].equals("*")) {
						result = result * aDouble;
					} else if (numTokens[i].equals("/")) {
						if (aDouble != 0) {
							result = result / aDouble;
						} else {
							System.out
									.println("Divison cannot be done for number "
											+ tokens[i - 1] + " / " + tokens[i]);
							opResult.setValid(false);
							opResult.setMessage("Divison cannot be done for number "
									+ tokens[i - 1] + " / " + tokens[i]);
							return opResult;
						}
					} else {
						System.out.println("Wrong operator between "
								+ tokens[i - 1] + " and " + tokens[i]);
						opResult.setValid(false);
						opResult.setMessage("Wrong operator between "
								+ tokens[i - 1] + " and " + tokens[i]);
						return opResult;
					}
				}
				opResult.setOutputResult(result);
				opResult.setValid(true);
				System.out.println("Result is on the server side: "
						+ result.intValue());
				return opResult;
			} else {
				System.out.println("Please enter the equation!!");
				opResult.setValid(false);
				opResult.setMessage("Please enter the equation!!");
				return opResult;
			}
		} catch (Exception e) {
			System.out.println("Exception occured with inputs " + e);
		}
		opResult.setValid(false);
		return opResult;
	}

	/**
	 * Message to check if the string has a valid number
	 **/
	public boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
