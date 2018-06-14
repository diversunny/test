package com.gerson.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gerson.ApiResult;
import com.gerson.ApiResultRow;
import com.gerson.IRemoteService;
import com.gerson.IResult;
import com.gerson.IResultRow;
import com.gerson.IService;
@Stateless
@Remote(IRemoteService.class)
@Local(IService.class)
public class Service implements IService,IRemoteService {

	public String getHello() {
		return "Hello";
	}

	public String[] getHelloArr() {
		return new String[] {"Hello","World","!"};
	}

	public List<IResultRow> getHellowList() {
		String[] words=getHelloArr();
		List<IResultRow>resultList=new ArrayList<IResultRow>();
		for(String word:words) {
			ResultRow row=new ResultRow(word);
			resultList.add(row);
		}
		return resultList;
	}
	@Override
	public List<IResultRow> getHelloApiList() {
		String[] words=getHelloArr();
		List<IResultRow>resultList=new ArrayList<IResultRow>();
		for(String word:words) {
			ApiResultRow row=new ApiResultRow(word);
			resultList.add(row);
		}
		return resultList;
	}


	public IResult getHellowResult() {
		return new Result(getHellowList());
	}

	@Override
	public ApiResult getApiResult() {
		String[] words=getHelloArr();
		List<IResultRow>resultList=new ArrayList<IResultRow>();
		for(String word:words) {
			IResultRow row=new ApiResultRow(word);
			resultList.add(row);
		}
		
		return new ApiResult(resultList);
	}

	
}
