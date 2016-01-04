/**
 * Logistics server side
 */
package com.logistics.simulator.network.reservation;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * @author yifan
 *
 */
public class ReservationManagerImplTest {

	/**
	 * Test method for {@link com.logistics.simulator.network.reservation.ReservationManagerImpl#AvailableUntil(java.time.LocalDateTime)}.
	 */
	@Test
	public void testAvailableUntil() {
		TimeSlotFactory timeSlotImplFactory = new TimeSlotImplFactory();
		ReservationManager ReservationManager = 
				new ReservationManagerImpl(timeSlotImplFactory);
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 02, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 04, 00);
		ReservationManager.reserve(start, end);
		
		// Set next time reserved
		start = LocalDateTime.of(2015, 11, 12, 20, 10, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 11, 00);
		ReservationManager.reserve(start, end);
		
		// Set next time reserved
		start = LocalDateTime.of(2015, 11, 12, 19, 40, 00);
		end = LocalDateTime.of(2015, 11, 12, 19, 50, 00);
		ReservationManager.reserve(start, end);
		
		// When check time is not even available, the result will be the same
		// as the checkTime
		LocalDateTime checkTime = LocalDateTime.of(2015, 11, 12, 20, 03, 00);
		LocalDateTime availableUntil = ReservationManager.availableUntil(checkTime);
		assertEquals(true, availableUntil.equals(checkTime));
		
		// If check time is available, the function should return the time when
		// it will be not available.
		checkTime = LocalDateTime.of(2015, 11, 12, 19, 00, 00);
		availableUntil = ReservationManager.availableUntil(checkTime);
		assertEquals(true, availableUntil.equals(start));
		
		// If the ReservationManager will be available all the time since check time, 
		// the function returns null.
		checkTime = LocalDateTime.of(2015, 11, 12, 21, 00, 00);
		availableUntil = ReservationManager.availableUntil(checkTime);
		assertNull(availableUntil);
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.reservation.ReservationManagerImpl#isTimeSlotAvailable(java.time.LocalDateTime, java.time.LocalDateTime)}.
	 */
	@Test
	public void testIsTimeSlotAvailable() {
		TimeSlotFactory timeSlotImplFactory = new TimeSlotImplFactory();
		ReservationManager ReservationManager = 
				new ReservationManagerImpl(timeSlotImplFactory);
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 02, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 04, 00);
		ReservationManager.reserve(start, end);
		
		// Overlap the start time
		start = LocalDateTime.of(2015, 11, 12, 20, 01, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 03, 00);
		assertFalse(ReservationManager.isTimeSlotAvailable(start, end));
		
		// Overlap the start time
		start = LocalDateTime.of(2015, 11, 12, 20, 03, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 05, 00);
		assertFalse(ReservationManager.isTimeSlotAvailable(start, end));
		
		// Within start to end
		start = LocalDateTime.of(2015, 11, 12, 20, 02, 30);
		end = LocalDateTime.of(2015, 11, 12, 20, 03, 00);
		assertFalse(ReservationManager.isTimeSlotAvailable(start, end));
		
		// A whole time slot is within requested time 
		start = LocalDateTime.of(2015, 11, 12, 20, 01, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 05, 00);
		assertFalse(ReservationManager.isTimeSlotAvailable(start, end));
		
		// Before reserved time
		start = LocalDateTime.of(2015, 11, 12, 20, 00, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 01, 00);
		assertTrue(ReservationManager.isTimeSlotAvailable(start, end));
		
		// After reserved time
		start = LocalDateTime.of(2015, 11, 12, 20, 05, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 06, 00);
		assertTrue(ReservationManager.isTimeSlotAvailable(start, end));
		
		// Exact the same time
		start = LocalDateTime.of(2015, 11, 12, 20, 02, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 04, 00);
		assertFalse(ReservationManager.isTimeSlotAvailable(start, end));
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.reservation.ReservationManagerImpl#reserve(java.time.LocalDateTime, java.time.LocalDateTime)}.
	 */
	@Test
	public void testReserve() {
		TimeSlotFactory timeSlotImplFactory = new TimeSlotImplFactory();
		ReservationManagerImpl ReservationManager = 
				new ReservationManagerImpl(timeSlotImplFactory);
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 02, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 04, 00);
		ReservationManager.reserve(start, end);
		
		// List size increased
		assertEquals(1, ReservationManager.reservedTimeSlot.size());
		for (TimeSlot timeSlot : ReservationManager.reservedTimeSlot) {
			assertTrue(timeSlot.getStartTime().equals(start));
			assertTrue(timeSlot.getEndTime().equals(end));
		}
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.reservation.ReservationManagerImpl#clearAllResearvation()}.
	 */
	@Test
	public void testClearAllResearvation() {
		TimeSlotFactory timeSlotImplFactory = new TimeSlotImplFactory();
		ReservationManagerImpl ReservationManager = new ReservationManagerImpl(timeSlotImplFactory);
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 02, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 04, 00);
		ReservationManager.reserve(start, end);
		
		ReservationManager.clearAllResearvation();
		assertEquals(0, ReservationManager.reservedTimeSlot.size());
	}

	/**
	 * Test method for {@link com.logistics.simulator.network.reservation.ReservationManagerImpl#clearExpiredReservation(java.time.LocalDateTime)}.
	 */
	@Test
	public void testClearExpiredReservation() {
		TimeSlotFactory timeSlotImplFactory = new TimeSlotImplFactory();
		ReservationManagerImpl ReservationManager = 
				new ReservationManagerImpl(timeSlotImplFactory);
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 2, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 4, 00);
		ReservationManager.reserve(start, end);
		start = LocalDateTime.of(2015, 11, 12, 20, 6, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 8, 00);
		ReservationManager.reserve(start, end);
		
		// Clear expired
		LocalDateTime time = LocalDateTime.of(2015, 11, 12, 20, 05, 00);
		ReservationManager.clearExpiredReservation(time);
		
		// Assertion
		assertEquals(1, ReservationManager.reservedTimeSlot.size());
		for (TimeSlot timeSlot : ReservationManager.reservedTimeSlot) {
			assertTrue(timeSlot.getStartTime().equals(start));
			assertTrue(timeSlot.getEndTime().equals(end));
		}
	}
	
	@Test
	public void testNextAvailableTime() {
		TimeSlotFactory timeSlotFactory = new TimeSlotImplFactory();
		ReservationManagerImpl ReservationManager = 
				new ReservationManagerImpl(timeSlotFactory);
		
		LocalDateTime start = LocalDateTime.of(2015, 11, 12, 20, 2, 00);
		LocalDateTime end = LocalDateTime.of(2015, 11, 12, 20, 4, 00);
		ReservationManager.reserve(start, end);
		
		start = LocalDateTime.of(2015, 11, 12, 20, 6, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 8, 00);
		ReservationManager.reserve(start, end);
		
		start = LocalDateTime.of(2015, 11, 12, 20, 12, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 13, 00);
		ReservationManager.reserve(start, end);
		
		// Check if next available time is found
		start = LocalDateTime.of(2015, 11, 12, 20, 0, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 3, 00);
		LocalDateTime time = ReservationManager.nextAvailableTime(start, end);
		assertTrue(time.equals(LocalDateTime.of(2015, 11, 12, 20, 8, 1)));
		
		// time should never be earlier than the from time
		start = LocalDateTime.of(2015, 11, 12, 20, 20, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 23, 00);
		time = ReservationManager.nextAvailableTime(start, end);
		assertTrue(time.equals(LocalDateTime.of(2015, 11, 12, 20, 20, 0)));
		
		// Right at the end of the last time slot
		start = LocalDateTime.of(2015, 11, 12, 20, 13, 00);
		end = LocalDateTime.of(2015, 11, 12, 20, 14, 00);
		time = ReservationManager.nextAvailableTime(start, end);
		assertTrue(time.equals(LocalDateTime.of(2015, 11, 12, 20, 13, 1)));
	}

}
