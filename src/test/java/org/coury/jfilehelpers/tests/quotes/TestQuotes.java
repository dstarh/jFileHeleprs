package org.coury.jfilehelpers.tests.quotes;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;

import junit.framework.Assert;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.junit.Test;


public class TestQuotes {

	@Test
	public void testQuotes(){
		StringBuilder s = new StringBuilder();
		s.append("'david'|'herman'");
		ByteArrayInputStream bais = new ByteArrayInputStream(s.toString().getBytes());
		InputStreamReader r = new InputStreamReader(bais);
		FileHelperEngine<Bean> e = new FileHelperEngine<Bean>(Bean.class);
		try {
			List<Bean> beans = e.readStream(r, -1);
			for (Bean b : beans) {
				Assert.assertEquals("david", b.getFirstName());
			}
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
