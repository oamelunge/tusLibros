package cartsystem;


import cartsystem.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import mergeandprocesorsystem.FakeMergeAndProcess;
import mergeandprocesorsystem.IMergeAndProcess;

public class InsideRest {
	List<ActiveCart> _listOfActiveCart = new ArrayList<ActiveCart>();
	Hashtable<String,String> _listOfUsers = new Hashtable<String, String>();
	private Cart _cart;
	private Cashier _cashier;
	private LocalDateTime _time;
	
	public InsideRest(LocalDateTime _time) {
		super();
		this._time = _time;
		settingUpUsers();
		settingUpCart();
	}

	public InsideRest() {
		settingUpUsers();
		settingUpCart();
		
	}

	public String createCart(String username, String password) {	
		
		validateUserPasswordCredentials(username, password);
		
		String id = creatingListOfActiveCarts();
		return id;
	}

	private void validateUserPasswordCredentials(String username,
			String password) {
		if(_listOfUsers.containsKey(username))
		{
			if(!_listOfUsers.get(username).equals(password))
				throw new RuntimeException("Invalid UserName or Password");
		}
		else
			throw new RuntimeException("Invalid UserName or Password");
	}
	
	private void settingUpUsers() {
		_listOfUsers.put("oamelunge","Lagarto33");		
	}

	public List<Object> listCartItems(String id) {
		return this.getActiveCart(id).get_cart().getlItems();
	}
	
	public ActiveCart getActiveCart(String id) {
		return _listOfActiveCart.stream()
				.filter(c -> c.get_idActiveCart()==id)
				.findFirst().get();
	}

	public void addItem(Object item, int quantity, String idCart) {
		 this.getActiveCart(idCart).get_cart().add(item, quantity);
	}
	
	public List<ActiveCart> get_listOfActiveCart() {
		return _listOfActiveCart;
	}
	
	public void checkOut(String id) {
		settingUpCashier();
		if(isValidLifeTimeForCart(id))
			throw new RuntimeException("time for purchase has expire");
		else
			_cashier.checkOut();
	}

	private boolean isValidLifeTimeForCart(String id) {
		return ChronoUnit.MINUTES.between(_time, getActiveCart(id).get_creationDateTime())>30;
	}

	private String creatingListOfActiveCarts() {
		ActiveCart activeCart = new ActiveCart(_cart,LocalDateTime.now());
		_listOfActiveCart.add(activeCart);
		return activeCart.get_idActiveCart();
	}
	
	private void settingUpCart() {
		Object libro1="12345";
		Object libro2="123456";
		Hashtable<Object,Double> catalog = new Hashtable<Object,Double>();
		catalog.put(libro1, 5.99);
		catalog.put(libro2, 4.99);
		_cart = new Cart(catalog);
	}
	private void settingUpCashier() {
		CreditCard card = new CreditCard("1111111111111111","Oscar Amelunge",new ExpirationDate(3, 2020));
		List<Object> sell = new ArrayList<Object>();
		List<Object> stolenCards = new ArrayList<Object>();
		
		Double maxAmount = 1900.80;
		IMergeAndProcess process = new FakeMergeAndProcess(maxAmount,stolenCards);
		
		_cashier = new Cashier(_cart,card,sell,process);
	}


}
