package gwtObserverStrategy.client.controller.strategy;

import gwtObserverStrategy.client.controller.CalculatorConstants;
import gwtObserverStrategy.client.model.CalculatorData;

public class OperatorDivide extends BinaryOperator {

	public OperatorDivide() {
		super(CalculatorConstants.DIVIDE);
	}

	public void operate(final CalculatorData data) {
		data.setDisplay(String.valueOf(data.getBuffer()
				/ Double.parseDouble(data.getDisplay())));
		data.setInitDisplay(true);
	}
}