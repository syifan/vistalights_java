/**
 * Logistics server side
 */
package com.logistics.simulator.network;

/**
 * @author yifan
 *
 */
public class NetworkImplFactory implements NetworkFactory {

	/* (non-Javadoc)
	 * @see com.logistics.simulator.network.NetworkFactory#produceNetwork()
	 */
	@Override
	public Network produceNetwork() {
		return new NetworkImpl();
	}

}
