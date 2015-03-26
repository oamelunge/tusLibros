package mergeandprocesorsystem;
import cartsystem.CreditCard;



public interface IMergeAndProcess {
	public boolean debit(CreditCard card, Double debitAmount);
}