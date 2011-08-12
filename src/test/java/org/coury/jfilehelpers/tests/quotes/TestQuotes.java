package org.coury.jfilehelpers.tests.quotes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import junit.framework.Assert;

import org.coury.jfilehelpers.engines.FileHelperEngine;
import org.junit.Test;

public class TestQuotes {

	@Test
	public void testWithQuotes() throws IOException {
		StringBuilder s = new StringBuilder();
		s.append("\"david\"|\"herman\"");
		ByteArrayInputStream bais = new ByteArrayInputStream(s.toString().getBytes());
		InputStreamReader r = new InputStreamReader(bais);
		FileHelperEngine<Bean> e = new FileHelperEngine<Bean>(Bean.class);

		List<Bean> beans = e.readStream(r, -1);
		for (Bean b : beans) {
			Assert.assertEquals("david", b.getFirstName());
		}

	}

	@Test
	public void testWithoutQuotes() throws IOException {
		StringBuilder s = new StringBuilder();
		s.append("david|herman");
		ByteArrayInputStream bais = new ByteArrayInputStream(s.toString().getBytes());
		InputStreamReader r = new InputStreamReader(bais);
		FileHelperEngine<Bean> e = new FileHelperEngine<Bean>(Bean.class);

		List<Bean> beans = e.readStream(r, -1);
		for (Bean b : beans) {
			Assert.assertEquals("david", b.getFirstName());
		}

	}

	@Test
	public void testWithQuotesAndNonEscapedDelimiter() throws IOException {
		StringBuilder s = new StringBuilder();
		s.append("\"dav|id\"|\"herman\"");
		ByteArrayInputStream bais = new ByteArrayInputStream(s.toString().getBytes());
		InputStreamReader r = new InputStreamReader(bais);
		FileHelperEngine<Bean> e = new FileHelperEngine<Bean>(Bean.class);

		try {
			List<Bean> beans = e.readStream(r, -1);
			for (Bean b : beans) {
				Assert.assertEquals("dav|id", b.getFirstName());
			}
		}
		catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Test
	public void testWithQuotesAndNonEscapedDelimiterAndExtraQuote() throws IOException {
		StringBuilder s = new StringBuilder();
		s.append("\"da\"\"vid\"|\"herman\"");
		ByteArrayInputStream bais = new ByteArrayInputStream(s.toString().getBytes());
		InputStreamReader r = new InputStreamReader(bais);
		FileHelperEngine<Bean> e = new FileHelperEngine<Bean>(Bean.class);

		List<Bean> beans = e.readStream(r, -1);
		for (Bean b : beans) {
			Assert.assertEquals("da\"vid", b.getFirstName());
		}

	}

}
