package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mergeandprocesorsystem.FakeMergeAndProcess;
import mergeandprocesorsystem.IMergeAndProcess;

import org.junit.Test;

import cartsystem.CreditCard;
import cartsystem.ExpirationDate;


public class TestMergeAndProcess {

	@Test
	public void testDebitShouldFailIfCreditCardHasNoFounds() {
		List<Object> stolenCards = new ArrayList<Object>();
		CreditCard card = new CreditCard("1111111111111111", "Oscar Amelunge", new ExpirationDate(3, 2020));
		Double debitAmount = 200.50;
		Double maxAmount = 190.80;
		IMergeAndProcess process = new FakeMergeAndProcess(maxAmount,stolenCards);
		
		try {
			process.debit(card,debitAmount);
			fail();
		} catch (Exception e) {
			assertEquals("not enought credit",e.getMessage());
		}
	}
	@Test
	public void testDebitShouldFailIfCreditCardIsStolen(){
		List<Object> stolenCards = new ArrayList<Object>();
		CreditCard card = new CreditCard("1111111111111111", "Oscar Amelunge", new ExpirationDate(3, 2020));
		stolenCards.add(card);
		Double debitAmount = 200.50;
		Double maxAmount = 190.80;
		IMergeAndProcess process = new FakeMergeAndProcess(maxAmount,stolenCards);
		
		try {
			process.debit(card,debitAmount);
			fail();
		} catch (Exception e) {
			assertEquals("stolen credit card imposible to process",e.getMessage());
		}
		
	}
	
	@Test
	public void testDebitShouldDebid(){
		List<Object> stolenCards = new ArrayList<Object>();
		CreditCard card = new CreditCard("1111111111111111", "Oscar Amelunge", new ExpirationDate(3, 2020));
		Double debitAmount = 200.50;
		Double maxAmount = 1900.80;
		IMergeAndProcess process = new FakeMergeAndProcess(maxAmount,stolenCards);
		assertTrue(process.debit(card, debitAmount));
	}

}
