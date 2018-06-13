package com.gerson.impl;

import java.io.Serializable;

import com.gerson.IResultRow;

public class ResultRow implements IResultRow, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	public ResultRow() {
		
	}
	public ResultRow(String word) {
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
