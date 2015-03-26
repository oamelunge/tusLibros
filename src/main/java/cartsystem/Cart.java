package cartsystem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Cart {

	private List<Object> _lItems;
	private Hashtable<Object,Double> _catalog;

	public Cart(Hashtable<Object,Double> catalog) {
		_catalog=catalog;
		_lItems = new ArrayList<Object>();
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public boolean isEmpty() {
		return _lItems.isEmpty();
	}
	public void add(Object item, int quantity) {
		if(quantity<1)
			throw new RuntimeException("items should be greather than 0");
		if(!_catalog.containsKey(item))
			throw new RuntimeException("this item is not in the cagalog");
		for(int q=0;q<quantity;q++)
		{
			_lItems.add(item);
		}
	}
	
	public List<Object> getlItems() {
		return _lItems;
	}
	
	public Hashtable<Object, Double> get_catalog() {
		return _catalog;
	}


}
