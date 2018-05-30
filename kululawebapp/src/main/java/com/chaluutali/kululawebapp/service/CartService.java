package com.chaluutali.kululawebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaluutali.kululawebapp.objects.ShoppingCart;
import com.chaluutali.kululawebapp.repository.CartRepository;


@Service
public class CartService {
	
	
	@Autowired
	private CartRepository cartRepository;

	public List<ShoppingCart> getAllCarts(Integer flightId) {
		
		List<ShoppingCart> carts = new ArrayList<>();
		cartRepository.findByScheduledFlightScheduledFlightId(flightId)
		.forEach(carts::add);
		return carts;
	}

	public Optional<ShoppingCart> getCart(int cartId) {
		return cartRepository.findById(cartId);
	}

	public void addCart(ShoppingCart shoppingCart) {
		cartRepository.save(shoppingCart);
	}

	public void deleteCart(int cartId) {
		cartRepository.deleteById(cartId);
	}

	public Optional<ShoppingCart> getCartBySearchLog(String searchlogId) {


		return cartRepository.findBySearchLogSearchLogDateId(searchlogId);
	}

}
