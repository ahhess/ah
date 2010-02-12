package gwtObserverStrategy.client.controller.strategy;

import gwtObserverStrategy.client.controller.CalculatorConstants;
import gwtObserverStrategy.client.model.CalculatorData;

public class OperatorSubtract extends BinaryOperator {

	public OperatorSubtract() {
		super(CalculatorConstants.SUBTRACT);
	}

	public void operate(final CalculatorData data) {
		data.setDisplay(String.valueOf(data.getBuffer()
				- Double.parseDouble(data.getDisplay())));
		data.setInitDisplay(true);
	}
}