package com.rmi.calculator.client;

import java.rmi.*;

import com.rmi.calculator.calculate.CalculatorInterface;
import com.rmi.calculator.server.Result;

public class TCPClient {
	public static void main(String args[]) {
		try {
			// mathematical equation
			String equation = args[0];

			// ipaddress
			String ipAddress = args[1];
			/** creating stub object **/
			CalculatorInterface stub = (CalculatorInterface) Naming
					.lookup("rmi://" + ipAddress + "/assignment6");
			Result res = stub.performCalculation(equation);
			/** if-else to check the output result **/
			if (res.isValid() == false) {
				System.out.println(res.getMessage()); // displays error message
			} else {
				System.out.println("Result received from server is: "
						+ res.getOutputResult().intValue()); // displays the
																// output result
			}
		}/** catch block to handle client side exceptions **/
		catch (Exception e) {
			System.out.println("Exception occured on client side: " + e);
		}
	}
}
