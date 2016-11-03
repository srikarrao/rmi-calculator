package com.rmi.calculator.server;

import java.rmi.*;
import com.rmi.calculator.calculate.CalculatorImpl;
import com.rmi.calculator.calculate.CalculatorInterface;

public class TCPServer {
	public static void main(String args[]) {
		try {
			// creating skeleton object
			CalculatorInterface skeleton = new CalculatorImpl();
			Naming.rebind("rmi://localhost/assignment6", skeleton);
		}/** catch block to handle server side exceptions **/
		catch (Exception e) {
			System.out.println("Exception occured at Server Side " + e);
		}
	}
}
