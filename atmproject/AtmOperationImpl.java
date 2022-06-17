package com.akash.atmproject;

import java.util.*;

public class AtmOperationImpl implements AtmOperations{
	ATM atm = new ATM();
	Map<Double,String> ministmt = new HashMap<>();
     
	AtmOperationImpl()
	{
	double openBalance = 0;
	ministmt.put(openBalance,"Opening Balance");
	}
	
	@Override
	
	public double viewBalance() {
		  return atm.getBalance();
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		
	                ministmt.put(withdrawAmount, " Amount Withdrawn");
	                atm.setBalance(atm.getBalance() - withdrawAmount);
	                viewBalance();
	            }

	@Override
	public void depositAmount(double depositAmount) {
		ministmt.put(depositAmount," Amount Deposited");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
		
	}

	@Override
	public String viewMiniStatement() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Double,String> m:ministmt.entrySet()){
            sb.append(m.getKey());
            sb.append(" ------> ");
            sb.append(m.getValue());
            sb.append('\n');
           
           
		}
		 return sb.toString();
	}

}

