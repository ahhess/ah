package gwtObserverStrategy.client.model;

import gwtObserverStrategy.client.model.observer.CalculatorChangeListener;
import gwtObserverStrategy.client.model.observer.CalculatorChangeNotifier;


public class CalculatorData implements CalculatorChangeNotifier {
	private String display;
	private double buffer;
	private boolean initDisplay;
	private boolean lastOpEquals;
	private CalculatorChangeListener listener;

	public CalculatorData() {
		this.clear();
	}

	public void addChangeListener(
	final CalculatorChangeListener listener) {
		this.listener = listener;                                      
	}

	public void clear() {
		this.display = "0";
		this.buffer = 0.0;
		this.initDisplay = true;
		this.lastOpEquals = false;
		if (listener != null) listener.onChange(this);
	}

	public double getBuffer() {
		return buffer;
	}

	public void setBuffer(double buffer) {
		this.buffer = buffer;
		listener.onChange(this);                                       
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
		listener.onChange(this);                                       
	}

	public boolean isInitDisplay() {
		return initDisplay;
	}

	public void setInitDisplay(boolean initDisplay) {
		this.initDisplay = initDisplay;
	}

	public boolean isLastOpEquals() {
		return lastOpEquals;
	}

	public void setLastOpEquals(boolean lastOpEquals) {
		this.lastOpEquals = lastOpEquals;
	}
}