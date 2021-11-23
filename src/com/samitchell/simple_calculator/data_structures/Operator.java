package com.samitchell.simple_calculator.data_structures;

public class Operator {
	private String operator;
	private int precendence;
	private String associativity;
	
	/**
	 * Default constructor - creates + operator by default.
	 */
	public Operator() {
		this("+", 0, "Left");
	}
	
	/**
	 * Non-default constructor
	 * @param operator	the operator as a String
	 * @param precedence	the precedence of the operator as an int (larger means higher precedence)
	 * @param associativity	the associativity: Left or Right of the operator
	 */
	public Operator(String operator, int precedence, String associativity) {
		this.operator = operator;
		this.precendence = precedence;
		this.associativity = associativity;
	}
	
	/**
	 * Accessor method for the associativity field
	 * @return	the value of the associativity field
	 */
	public String getAssociativity() {
		return this.associativity;
	}
	
	/**
	 * Accessor method for the operator field
	 * @return	the value of the operator field
	 */
	public String getOperator() {
		return this.operator;
	}
	
	/**
	 * Accessor method for the precedence field
	 * @return	the value of the precedence field
	 */
	public int getPrecedence() {
		return this.precendence;
	}
	
	/**
	 * Mutator method for the associativity field
	 * @param associativity	the new value for the field
	 */
	public void setAssociativity(String associativity) {
		this.associativity = associativity;
	}
	
	/**
	 * Mutator method for the operator field
	 * @param operator	the new value for the field
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Mutator method for the precedence field
	 * @param precedence	the new value for the field
	 */
	public void setPrecedence(int precedence) {
		this.precendence = precedence;
	}
}
