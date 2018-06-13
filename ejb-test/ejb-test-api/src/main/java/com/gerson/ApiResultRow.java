package com.gerson;

public class ApiResultRow implements IResultRow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	public ApiResultRow() {
		
	}
	public ApiResultRow(String word) {
		this();
		this.setText(word);
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
