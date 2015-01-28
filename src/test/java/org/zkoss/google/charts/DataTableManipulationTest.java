package org.zkoss.google.charts;

import org.junit.Test;
import org.zkoss.google.charts.data.DataTable;

import static org.junit.Assert.assertEquals;

/**
 * @author Sean Connolly
 */
public class DataTableManipulationTest {

	@Test
	public void shouldReflectCorrectColumnsA() {
		// Given
		DataTable table = new DataTable();
		table.addRow();
		table.addStringColumn("Column 1");
		// When
		table.addStringColumn("Column 2");
		// Then
		assertEquals(2, table.getNumberOfColumns());
	}

	@Test
	public void shouldReflectCorrectColumnsB() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addRow();
		// When
		table.addStringColumn("Column 2");
		// Then
		assertEquals(2, table.getNumberOfColumns());
	}

	@Test
	public void shouldReflectCorrectColumnsC() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addStringColumn("Column 2");
		// When
		table.addRow();
		// Then
		assertEquals(2, table.getNumberOfColumns());
	}

	@Test
	public void shouldReflectCorrectRowsA() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addRow();
		// When
		table.addRow();
		// Then
		assertEquals(2, table.getNumberOfRows());
	}

	@Test
	public void shouldReflectCorrectRowsB() {
		// Given
		DataTable table = new DataTable();
		table.addRow();
		table.addStringColumn("Column 1");
		// When
		table.addRow();
		// Then
		assertEquals(2, table.getNumberOfRows());
	}

	@Test
	public void shouldReflectCorrectRowsC() {
		// Given
		DataTable table = new DataTable();
		table.addRow();
		table.addRow();
		// When
		table.addStringColumn("Column 1");
		// Then
		assertEquals(2, table.getNumberOfRows());
	}

	@Test
	public void shouldGetValueX() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		Object value = table.getValue(0, 0);
		// Then
		assertEquals("X", value);
	}

	@Test
	public void shouldGetValue42() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		Object value = table.getValue(0, 1);
		// Then
		assertEquals(42, value);
	}

	@Test
	public void shouldGetValueY() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		Object value = table.getValue(1, 0);
		// Then
		assertEquals("Y", value);
	}

	@Test
	public void shouldGetValue137() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		Object value = table.getValue(1, 1);
		// Then
		assertEquals(137, value);
	}

	@Test
	public void shouldSetValue() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		table.setValue(0, 1, 99);
		Object value = table.getValue(0, 1);
		// Then
		assertEquals(99, value);
	}

	@Test
	public void shouldNotSetOtherValue() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addNumberColumn("Column 2");
		table.addRow("X", 42);
		table.addRow("Y", 137);
		// When
		table.setValue(0, 1, "TEST");
		Object value = table.getValue(1, 1);
		// Then
		assertEquals(137, value);
	}

	@Test
	public void shouldSetInitialValue() {
		// Given
		DataTable table = new DataTable();
		table.addStringColumn("Column 1");
		table.addRow();
		// When
		table.setValue(0, 0, "TEST");
		Object value = table.getValue(0, 0);
		// Then
		assertEquals("TEST", value);
	}

}
