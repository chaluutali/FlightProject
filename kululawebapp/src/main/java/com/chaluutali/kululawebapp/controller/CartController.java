package com.chaluutali.kululawebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaluutali.kululawebapp.objects.ScheduledFlight;
import com.chaluutali.kululawebapp.objects.SearchLog;
import com.chaluutali.kululawebapp.objects.SeatSelectionLog;
import com.chaluutali.kululawebapp.objects.ShoppingCart;
import com.chaluutali.kululawebapp.objects.User;
import com.chaluutali.kululawebapp.service.CartService;




@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class CartController 
{
	@Autowired
	private CartService cartService;

	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart/all")
	public List<ShoppingCart> getAllCarts(@PathVariable int flightId)
	{
		return cartService.getAllCarts(flightId);
	}
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart")
	public Optional<ShoppingCart> getCartBySearchLog(@PathVariable String searchLogDateId)
	{
		return cartService.getCartBySearchLog(searchLogDateId);
	}
	
	@RequestMapping("/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart/{cartId}")
	public Optional<ShoppingCart> getCart(@PathVariable int cartId) 
	{
		return cartService.getCart(cartId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart")
	public void addCart(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId,  @RequestBody ShoppingCart shoppingCart)
	{
		
		shoppingCart.setSearchLog(new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress)));
		shoppingCart.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		cartService.addCart(shoppingCart);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart/{cartId}")
	public void updateCart(@PathVariable String emailAddress, @PathVariable String searchLogDateId, @PathVariable int flightId, @PathVariable String cartId,  @RequestBody ShoppingCart shoppingCart) 
	{
		shoppingCart.setScheduledFlight(new ScheduledFlight(flightId, new SearchLog(searchLogDateId, new User(null,null,null,false,null,null,null, emailAddress))));
		cartService.addCart(shoppingCart);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart/{cartId}")
	public void deleteCart(@PathVariable int cartId) 
	{
		cartService.deleteCart(cartId);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{emailAddress}/searchlog/{searchLogDateId}/flight/{flightId}/cart/bysearchlog")
	public void deleteCartBySearchLogDate(@PathVariable String searchLogDateId) 
	{
		cartService.deleteCartBySearchLogDate(searchLogDateId);
	}


}
