package com.rmi.calculator.calculate;

import java.rmi.*;
import com.rmi.calculator.server.Result;

public interface CalculatorInterface extends Remote {
	public Result performCalculation(String equation) throws RemoteException;
}
