package com.gerson;

import java.io.Serializable;
import java.util.List;

public interface IResult extends Serializable {
	public List<IResultRow> getResult();
}
