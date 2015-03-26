package cartsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ActiveCart {

	private String _idActiveCart;
	private Cart _cart;
	
	private LocalDateTime _creationDateTime;

	public ActiveCart(Cart cart, LocalDateTime creationDateTime) {
		this._idActiveCart =UUID.randomUUID().toString();;
		this._cart = cart;
		this._creationDateTime = creationDateTime;
	}
	
	public String get_idActiveCart() {
		return _idActiveCart;
	}
	public Cart get_cart() {
		return _cart;
	}
	public LocalDateTime get_creationDateTime() {
		return _creationDateTime;
	}

}
