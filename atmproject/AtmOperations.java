package com.akash.atmproject;

public interface AtmOperations {
	
	public double viewBalance();
	public void withdrawAmount(double withdrawAmount);
	public void depositAmount (double depositAmount );
	public String viewMiniStatement();

}
