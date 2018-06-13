package com.gerson.impl;

import java.io.Serializable;
import java.util.List;

import com.gerson.IResult;
import com.gerson.IResultRow;

public class Result implements IResult,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<IResultRow> result;
	public Result() {
		
	}
	public Result(List<IResultRow> hellowList) {
		this();
		this.result=hellowList;
	}
	public List<IResultRow> getResult() {
		return result;
	}
	public void setResult(List<IResultRow> result) {
		this.result = result;
	}
	
}
