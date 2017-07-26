package com.wildfly.ejb;

import java.util.Collection;

import javax.ejb.EJB;

import com.wildfly.control.TheatreBox;
import com.wildfly.domain.Seat;
import com.wildfly.ejb.interfaces.TheatreInfoRemote;

public class TheatreInfo implements TheatreInfoRemote {
	
	@EJB
	private TheatreBox box;

	public String printSeatList() {
		final Collection<Seat> seats = box.getSeats();
		final StringBuilder sb = new StringBuilder();
		for (Seat seat : seats) {
			sb.append(seat.toString());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}
