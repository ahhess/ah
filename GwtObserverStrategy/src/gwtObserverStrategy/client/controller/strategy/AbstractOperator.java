package gwtObserverStrategy.client.controller.strategy;

import gwtObserverStrategy.client.model.CalculatorData;

public abstract class AbstractOperator {
	public String label;

	AbstractOperator(final String label) {
		this.label = label;
	}
	public abstract void operate(
		final CalculatorData data);                                    
}