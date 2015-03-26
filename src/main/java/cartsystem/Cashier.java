package cartsystem;
import java.util.List;

import mergeandprocesorsystem.IMergeAndProcess;


public class Cashier {

	private Cart _cart;
	private CreditCard _card;
	private List<Object> _sell;
	private Double _total=0.0;



	private IMergeAndProcess _process;

	public Cashier(Cart cart, CreditCard card, List<Object> sell, IMergeAndProcess process) {
		this._cart = cart;
		this._card = card;
		this._sell = sell;
		this._process = process;
	}

	
	public boolean checkOut() {
		checkIfCartIsNotEmpty();
		calculateTotalSellAmount();
		return debitSellFromCreditCard();
	}


	private boolean debitSellFromCreditCard() {
		if (_process.debit(_card, _total))
		{
			registerSell();
			return true;
		}
		return false;
	}


	private void registerSell() {
		_sell.addAll(_cart.getlItems());
	}

	private void calculateTotalSellAmount() {
		for(Object item:_cart.getlItems())
		{
			_total+=_cart.get_catalog().get(item).doubleValue();
			
		}
	}

	private void checkIfCartIsNotEmpty() {
		if(_cart.isEmpty())
			throw new RuntimeException("checkout on empty cart is not allowed");
	}

	
	public List<Object> getSells() {
		return _sell;
	}
	
	public Double get_total() {
		return _total;
	}

}
