/**
 * Logistics server side
 */
package com.logistics.shared;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author yifan
 *
 */
public class TestPoint3D {

	@Test
	public void testCrossProduct() {
		Point3D a = new Point3D(1, 2, 3);
		Point3D b = new Point3D(4, 5, 6);
		Point3D c = a.crossProduct(b);
		assertEquals(-3, c.getX(), 1e-6);
		assertEquals(6, c.getY(), 1e-6);
		assertEquals(-3, c.getZ(), 1e-6);
	}

}
