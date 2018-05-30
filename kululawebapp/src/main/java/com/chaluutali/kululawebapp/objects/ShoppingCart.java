package com.chaluutali.kululawebapp.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart
{
	
	private double cartTotal;
	
	@OneToOne
	private PerPersonFares perPersonFares;
	
	private int seatSelectionLog;
	@OneToOne
	private Extras extras;

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	@OneToOne
	private ScheduledFlight scheduledFlight;
	
	@OneToOne
	private SearchLog searchLog;
	
	
	public ShoppingCart()
	{
		
	}
	


	public ShoppingCart(double cartTotal, PerPersonFares perPersonFares,
			int seatSelectionLog, Extras extras, int cartId, ScheduledFlight scheduledFlight, SearchLog searchLog) {
		super();
		this.cartTotal = cartTotal;
		
		this.perPersonFares = new PerPersonFares();
		this.seatSelectionLog = seatSelectionLog;
		this.extras = new Extras();
		this.cartId = cartId;
		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
	}



	public ShoppingCart(int cartId2, ScheduledFlight scheduledFlight2, SearchLog searchLog) {


		this.scheduledFlight = new ScheduledFlight();
		this.searchLog = new SearchLog();
		this.cartId = cartId2;
	}



	public double getCartTotal() {
		return cartTotal;
	}


	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}



	public PerPersonFares getPerPersonFares() {
		return perPersonFares;
	}


	public void setPerPersonFares(PerPersonFares perPersonFares) {
		this.perPersonFares = perPersonFares;
	}


	public int getSeatSelectionLog() {
		return seatSelectionLog;
	}


	public void setSeatSelectionLog(int seatSelectionLog) {
		this.seatSelectionLog = seatSelectionLog;
	}


	public Extras getExtras() {
		return extras;
	}


	public void setExtras(Extras extras) {
		this.extras = extras;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}


	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}



	public SearchLog getSearchLog() {
		return searchLog;
	}



	public void setSearchLog(SearchLog searchLog) {
		this.searchLog = searchLog;
	}
	
	




	
	
}
