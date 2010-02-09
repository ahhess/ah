package gwtObserverStrategy.client.view;

import gwtObserverStrategy.client.controller.CalculatorConstants;
import gwtObserverStrategy.client.controller.CalculatorController;
import gwtObserverStrategy.client.controller.strategy.OperatorAdd;
import gwtObserverStrategy.client.controller.strategy.OperatorDivide;
import gwtObserverStrategy.client.controller.strategy.OperatorMultiply;
import gwtObserverStrategy.client.controller.strategy.OperatorSubtract;
import gwtObserverStrategy.client.model.CalculatorData;
import gwtObserverStrategy.client.model.observer.CalculatorChangeListener;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CalculatorWidget extends VerticalPanel {
	private TextBox display;

	public CalculatorWidget() {

		super();

		final CalculatorData data = new CalculatorData();

		final CalculatorController controller = new CalculatorController(data);

		VerticalPanel p = new VerticalPanel();
		p.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		// p.setStyleName(CalculatorConstants.STYLE_PANEL);

		Grid g = new Grid(4, 5);
		// g.setStyleName(CalculatorConstants.STYLE_GRID);

		// [display]
		// 7 8 9 / C 
		// 4 5 6 *
		// 1 2 3 - 
		//   0 . + =
		
		g.setWidget(3, 1, new ButtonDigit(controller, "0"));
		g.setWidget(2, 0, new ButtonDigit(controller, "1"));
		g.setWidget(2, 1, new ButtonDigit(controller, "2"));
		g.setWidget(2, 2, new ButtonDigit(controller, "3"));
		g.setWidget(1, 0, new ButtonDigit(controller, "4"));
		g.setWidget(1, 1, new ButtonDigit(controller, "5"));
		g.setWidget(1, 2, new ButtonDigit(controller, "6"));
		g.setWidget(0, 0, new ButtonDigit(controller, "7"));
		g.setWidget(0, 1, new ButtonDigit(controller, "8"));
		g.setWidget(0, 2, new ButtonDigit(controller, "9"));

		g.setWidget(3, 2, new ButtonDigit(controller, CalculatorConstants.POINT));

		g.setWidget(0, 3, new ButtonOperator(controller, new OperatorDivide()));
		g.setWidget(1, 3, new ButtonOperator(controller, new OperatorMultiply()));
		g.setWidget(2, 3, new ButtonOperator(controller, new OperatorSubtract()));
		g.setWidget(3, 3, new ButtonOperator(controller, new OperatorAdd()));

		final Button clear = new Button(CalculatorConstants.CLEAR);
		clear.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				controller.processClear();
			}
		});
		// clear.setStyleName(CalculatorConstants.STYLE_BUTTON);
		g.setWidget(0, 4, clear);
		
		final Button equals = new Button(CalculatorConstants.EQUALS);
		equals.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				controller.processEquals();
			}
		});
		// clear.setStyleName(CalculatorConstants.STYLE_BUTTON);
		g.setWidget(3, 4, equals);

		display = new TextBox();
		display.setText("0");
		display.setTextAlignment(TextBox.ALIGN_RIGHT);

		data.addChangeListener(new CalculatorChangeListener() {
			public void onChange(CalculatorData data) {
				display.setText(String.valueOf(data.getDisplay()));
			}
		});

		p.add(display);
		p.add(g);
		this.add(p);
	}
}
