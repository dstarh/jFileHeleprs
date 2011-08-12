package org.coury.jfilehelpers.tests.quotes;

import org.coury.jfilehelpers.annotations.DelimitedRecord;
import org.coury.jfilehelpers.enums.QuoteMode;

@DelimitedRecord(value="|", quoteChar='\'', quoteMode=QuoteMode.OptionalForBoth)
public class Bean {
	private String firstName;

	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}