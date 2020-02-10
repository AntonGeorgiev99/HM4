import org.junit.Test;

import static org.junit.Assert.*;

public class Cheecktest {

    @Test
    public void getWord() {
        Cheeck check = new Cheeck("Test");
        assertEquals("Test", check.getWord());

    }

	private void assertEquals(String string, String word) {
		// TODO Auto-generated method stub
		
	}
}