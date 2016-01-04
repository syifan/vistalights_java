/**
 * Logistics server side
 */
package com.logistics.visualizerbasic;

/**
 * @author yifansun
 *
 */
public interface PropagationStoppable {
	public boolean isStopped();
	public void preventPropagation();
}
