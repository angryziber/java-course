package net.azib.java.students.t073857.hw8;

import java.math.BigDecimal;

/**
 * Calculator
 *
 * @author Joonas Vali
 */
public class Calculator {
	StringBuilder screen = new StringBuilder("0");
	boolean setNewInput=false;
	boolean ignoreOperator = false;
	boolean equalsMore = false;	
	
	String previous;	
	String temp;
	int operator;
	
	public Calculator(){
		init();
	}
	
	public void type(char input){		
		if(Character.isDigit(input) || input == ',' && !screen.toString().contains(",")){
			if(equalsMore) init();
				
			if(setNewInput){
				screen = new StringBuilder(input);
				setNewInput = false;
			}
			if(input == '0' && screen.toString().equals("0")) return;
			if(input != ',' && screen.toString().equals("0")) screen.deleteCharAt(0);
			screen.append(input);			
			ignoreOperator = false;
			equalsMore = false;
		}
		else if((input == '+' || input == '%' || input == '*' || input == '-') && !ignoreOperator){
			if(previous != null && !equalsMore){
				calculate();
				screen = new StringBuilder(previous);				
			} else if(equalsMore){
				calculate();
				previous = screen.toString();
				equalsMore = false;
			} else {
				previous = screen.toString();
				
			}
			setNewInput = true;
			operator = input;
			ignoreOperator = true;
		}
		else if(input == '=' && !ignoreOperator){
			try{
				if(!equalsMore)
					temp = screen.toString();			
				else{
					previous = screen.toString();
					screen = new StringBuilder(temp);
				}			
				calculate();
				screen = new StringBuilder(previous);
				setNewInput = true;			
				equalsMore = true;
			} catch(NullPointerException e){}
		}
		if(input == 'C'){
			init();
		}
	}
	
	public void init(){
		screen = new StringBuilder("0");
		setNewInput=false;
		ignoreOperator = false;
		equalsMore = false;		
		previous = null;	
		temp = null;
		operator = 0;
	}
	
	@Override
	public String toString(){
		if(screen.toString().startsWith("0E")) return "0";
		else return screen.toString();
	}
	
	
	private void calculate(){
		BigDecimal first = new BigDecimal(previous.replace(",", "."));
		BigDecimal second = new BigDecimal(screen.toString().replace(",", "."));
		switch(operator){
			case '+': previous = first.add(second).toString(); break;
			case '*': previous = first.multiply(second).toString(); break;
			case '-': previous = first.subtract(second).toString(); break;
			case '%': 				
				try{
					previous = first.divide(second, 20, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();					
				} catch(ArithmeticException e){	
					init();
					screen = new StringBuilder("Error");
				}
				break;
		}		
	}
}
