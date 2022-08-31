package babel.compares.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;

public interface IOperacionsDigitalCenter {

	public Map<Object,Object> readDoc(List<String> head,String filter) throws Exception;
	public List<Object> MapToList(List<String> head) throws Exception;
	public List<String> getListName() throws Exception;
	public List<Integer> getListKey() throws Exception;
	public List<Object> getListValues() throws Exception;
	public Object getPersonDigitlaCenterByCode(Integer key) throws Exception;
	public List<Object> getListPersonDigitlaCenterByCode(List<Integer> listKey) throws Exception;
	public List<Object> getListPersonDigitlaCenter() throws Exception;
	
	public Map<Integer, String> getMapPersonDigitalByTechnology(String filter);
	public List<Object> getListPersonDigitalByTechnology(String filter) throws Exception;
	
	
	public boolean thereAreDuplicates() throws Exception;
	public List<Object> getListPersonDigitalDuplicate() throws Exception;
	public boolean thereArePersonWithOutEmpledCode()throws Exception;
	public List<Object> getListPersonDigitalWithOutEmpledCode() throws Exception;
	public boolean thereArePersonWithOutCommunity()throws Exception;
	public List<Object> getListPersonDigitalWithOutCommunity() throws Exception;
}
