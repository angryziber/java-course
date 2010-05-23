package net.azib.java.students.t073857.hw5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * EmailTest
 *
 * @author Joonas Vali
 */
public class EmailTest {
	String adr = "test";
	String domain = "t073857.ee";
	Email e = new Email(adr+"@"+domain);
	
	@Test
	public void fullAddress(){
		assertEquals(adr+"@"+domain, e.toString());
	}
	
	@Test
	public void domainName(){
		assertEquals(domain, e.getDomain());
	}
	
	@Test
	public void userAddress(){
		assertEquals(adr, e.getUser());
	}
	
	@Test
	public void correctAddresses(){
		try{
			new Email("joonas.vali@hotmail.com");
			new Email("address@Independent.co.uk");
			new Email("address1351335@Independent555.co.uk");
			new Email("1234.address1351335@Independent555.co.uk");
			new Email("Eesti@Test.ee");
			new Email("not.my.real.address@hotmail.com");			
		} catch(IllegalArgumentException e){
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void illegalAddresses(){
		try{
			new Email("AOJG93");
			throw new AssertionError("\"AOJG93\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("#OIMG.03KA");
			throw new AssertionError("\"#OIMG.03KA\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("3aa@");
			throw new AssertionError("\"3aa@\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("@@@");
			throw new AssertionError("\"@@@\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("asfg.w@w");
			throw new AssertionError("\"asfg.w@w\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("asfg@w.c");
			throw new AssertionError("\"asfg@w.c\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}
		try{
			new Email("@w.ac.com");
			throw new AssertionError("\"@w.ac.com\" didn't fail when initializing a new email");
		} catch(IllegalArgumentException e){}		
		
	}
	
}
