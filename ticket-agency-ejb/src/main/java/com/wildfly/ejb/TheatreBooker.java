package com.wildfly.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import com.wildfly.control.TheatreBox;
import com.wildfly.ejb.interfaces.TheatreBookerRemote;
import com.wildfly.exception.NoSuchSeatException;
import com.wildfly.exception.NotEnoughMoneyException;
import com.wildfly.exception.SeatBookedException;
import java.util.concurrent.TimeUnit;

@Stateful
@Remote (TheatreBookerRemote.class)
@AccessTimeout (value = 5, unit = TimeUnit.MINUTES)
public class TheatreBooker implements TheatreBookerRemote {
	private static final Logger logger = Logger.getLogger(TheatreBooker.class);
	
	@EJB
	private TheatreBox theatreBox;
	private int money;
	
	@PostConstruct
	public void createCustomer() {
		this.money = 100;
	}
	
	public int getAccountBalance() {
		return money;
	}
	
	public String bookSeat (int seatId) throws SeatBookedException, NoSuchSeatException, NotEnoughMoneyException {
		final int seatPrice = theatreBox.getSeatPrice (seatId);
		if (seatPrice > money){
			throw new NotEnoughMoneyException("You don't have enough money to by this seat: " + seatId);
		}
		theatreBox.buyTicket(seatId);
		money = money - seatPrice;
		
		logger.infov("Seat {0} booked.", seatId);
		return "Seat booked.";
	}
}
