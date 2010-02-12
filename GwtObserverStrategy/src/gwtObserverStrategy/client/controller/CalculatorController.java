package gwtObserverStrategy.client.controller;

import gwtObserverStrategy.client.controller.strategy.AbstractOperator;
import gwtObserverStrategy.client.controller.strategy.BinaryOperator;
import gwtObserverStrategy.client.controller.strategy.UnaryOperator;
import gwtObserverStrategy.client.model.CalculatorData;

public class CalculatorController {

	CalculatorData data;
	AbstractOperator lastOperator;
	private double prevBuffer; 

	public CalculatorController(
		   final CalculatorData data) {                                
		this.data = data;
	}

	public void processClear() {                                       
		data.clear();
		lastOperator = null;
	}

	public void processEquals() {                                      
		if (lastOperator != null) {
			if (!data.isLastOpEquals()) {
				prevBuffer = Double.parseDouble(data.getDisplay());
			}
			lastOperator.operate(data);
			data.setBuffer(prevBuffer);
			data.setLastOpEquals(true);
		}
	}

	public void processOperator(
				final AbstractOperator op) {                           
		if (op instanceof BinaryOperator) {
			if ((lastOperator == null) || (data.isLastOpEquals())) {
				data.setBuffer(Double.parseDouble(data.getDisplay()));
				data.setInitDisplay(true);
			} else {
				lastOperator.operate(data);
			} 
				lastOperator = op;
		} else if (op instanceof UnaryOperator) {
			op.operate(data);
		}
		data.setLastOpEquals(false);
	}

	public void processDigit(final String s) {                         
		if (data.isLastOpEquals()) {
			lastOperator = null;
		}
		if (data.isInitDisplay()) {
			if (data.isLastOpEquals()) {
				data.setBuffer(0.0);
			} else {
				data.setBuffer(Double.parseDouble(data.getDisplay()));
			}
			data.setDisplay(s);
			data.setInitDisplay(false);
		} else {
			if (data.getDisplay().indexOf(
				   CalculatorConstants.POINT) == -1) {
				data.setDisplay(data.getDisplay() + s);
			} else if (!s.equals(CalculatorConstants.POINT)) {
				data.setDisplay(data.getDisplay() + s);
			}
		}
		data.setLastOpEquals(false);
	}
}
