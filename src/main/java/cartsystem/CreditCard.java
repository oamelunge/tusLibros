package cartsystem;
import java.util.regex.Pattern;


public class CreditCard {

	private String _number;
	private String _holder;
	private ExpirationDate _expirationDate;

	public CreditCard(String number, String holder, ExpirationDate expirationDate) {
		validateCreditCardNumber(number);
		this._number = number;
		this._holder = holder;
		
		this._expirationDate = expirationDate;
	}

	private void validateCreditCardNumber(String number) {
		isCreditCardNumberEmpty(number);
		isCreditCardNumberOfDigitsValid(number);
		isCreditCardNumberFormOnlyByNumbers(number);
	}

	private void isCreditCardNumberFormOnlyByNumbers(String number) {
		if(Pattern.compile(".*[^0-9].*").matcher(number).matches())
			throw new RuntimeException("cc should be only numbers");
	}

	private void isCreditCardNumberOfDigitsValid(String number) {
		if(number.length()<16 || number.length()>16)
			throw new RuntimeException("cc should be 16 digits");
	}

	private void isCreditCardNumberEmpty(String number) {
		if(number.isEmpty())
			throw new RuntimeException("cc number could not be empty");
	}

	public String getNumber() {
		return this._number;
	}

	public String getHolder() {
		return this._holder;
	}

	public Object getExpirationDate() {
		return this._expirationDate;
	}

}
