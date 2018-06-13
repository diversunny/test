package com.gerson;

import java.util.List;

public interface IService {

	public String getHello();
	public String[] getHelloArr();
	public List<IResultRow> getHellowList();
	public IResult getHellowResult();
	public ApiResult getApiResult();
}
