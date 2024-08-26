package com.marondal.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.ajax.domain.Booking;
import com.marondal.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	
	public List<Booking> getBookingList() {
		List<Booking> bookingList = bookingRepository.selectBookingList();
		
		return bookingList;
	}
	
	public int addBooking(
			String name
			, LocalDate date
			, int day
			, int headcount
			, String phoneNumber) {
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
		
		return count;
		
	}

}
