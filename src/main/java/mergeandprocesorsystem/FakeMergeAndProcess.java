package mergeandprocesorsystem;

import java.util.List;

import cartsystem.CreditCard;


public class FakeMergeAndProcess implements IMergeAndProcess {

	private Double _maxAmount;
	private List<Object> _stolenCards;

	public FakeMergeAndProcess(Double maxAmount, List<Object> stolenCards) {
		this._maxAmount = maxAmount;
		this._stolenCards = stolenCards;
	}

	public boolean debit(CreditCard card, Double debitAmount) {
		if(_stolenCards.contains(card))
			throw new RuntimeException("stolen credit card imposible to process");
		if(debitAmount>_maxAmount)
			throw new RuntimeException("not enought credit");
		return true;
	}

}
