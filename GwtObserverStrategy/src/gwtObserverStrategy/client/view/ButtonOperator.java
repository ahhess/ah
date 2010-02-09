package gwtObserverStrategy.client.view;

import gwtObserverStrategy.client.controller.CalculatorController;
import gwtObserverStrategy.client.controller.strategy.AbstractOperator;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

public class ButtonOperator extends Button {
	public ButtonOperator(final CalculatorController controller,
		final AbstractOperator op) {                                   
		super(op.label);
		this.addClickListener(new ClickListener() {                    
				public void onClick(Widget sender) {	
					controller.processOperator(op);
				}
			});
//		this.setStyleName(CalculatorConstants.STYLE_BUTTON_OPERATOR); 
	}
}