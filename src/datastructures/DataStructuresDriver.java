/**
 * Data Structures Samples
 */
package datastructures;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author adrianafuentes
 *
 */
public class DataStructuresDriver {
	
	ExtendArrayExample ea;
	
	public DataStructuresDriver() {
		ea = new ExtendArrayExample();
	}

	@Test
	public void testExtendArray() {
		int[] values = {3, 4, 5, 6, 7};
		
		values = ea.extendArrayWithArrayCopy(values);
		
		assertEquals(8, values[5]);
		assertEquals(9, values[6]);
		assertEquals(10, values[7]);
	}
}
