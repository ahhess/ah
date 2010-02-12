package gwtObserverStrategy.client.controller.strategy;

import gwtObserverStrategy.client.controller.CalculatorConstants;
import gwtObserverStrategy.client.model.CalculatorData;

public class OperatorMultiply extends BinaryOperator {

	public OperatorMultiply() {
		super(CalculatorConstants.MULTIPLY);
	}

	public void operate(final CalculatorData data) {
		data.setDisplay(String.valueOf(data.getBuffer()
				* Double.parseDouble(data.getDisplay())));
		data.setInitDisplay(true);
	}
}