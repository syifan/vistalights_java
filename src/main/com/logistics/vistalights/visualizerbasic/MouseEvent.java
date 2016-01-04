/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public class MouseEvent 
	extends processing.event.MouseEvent 
	implements PropagationStoppable{

	/**
	 * Determines if the propagation is stopped
	 */
	protected boolean propagationStopped = false;
	
	/**
	 * @param nativeObject
	 * @param millis
	 * @param action
	 * @param modifiers
	 * @param x
	 * @param y
	 * @param button
	 * @param count
	 */
	public MouseEvent(processing.event.MouseEvent event) {
		super(event.getNative(), 
				event.getMillis(), 
				event.getAction(), 
				event.getModifiers(), 
				event.getX(), 
				event.getY(), 
				event.getButton(), 
				event.getCount());
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.PropagationStoppable#isStopped()
	 */
	@Override
	public boolean isStopped() {
		return propagationStopped;
	}

	/* (non-Javadoc)
	 * @see com.logistics.visualizerbasic.PropagationStoppable#preventPropagation()
	 */
	@Override
	public void preventPropagation() {
		this.propagationStopped = true;
	}

}
