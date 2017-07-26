package com.wildfly.ejb.interfaces;

import com.wildfly.exception.NoSuchSeatException;
import com.wildfly.exception.SeatBookedException;
import com.wildfly.exception.NotEnoughMoneyException;

public interface TheatreBookerRemote {
	int getAccountBalance();
	String bookSeat(int seatId) throws SeatBookedException, NotEnoughMoneyException, NoSuchSeatException;
}
