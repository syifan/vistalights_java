/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public class KeyEvent 
	extends processing.event.KeyEvent
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
	 * @param key
	 * @param keyCode
	 */
	public KeyEvent(processing.event.KeyEvent event) {
		super(event.getNative(), 
				event.getMillis(), 
				event.getAction(), 
				event.getModifiers(), 
				event.getKey(), 
				event.getKeyCode());
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
