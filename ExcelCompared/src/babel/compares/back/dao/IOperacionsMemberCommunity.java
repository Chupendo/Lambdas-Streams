package babel.compares.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import babel.compares.back.dto.MemberCommunityManager;
import babel.compares.back.dto.MemberCommunityPublic;

public interface IOperacionsMemberCommunity {

	public Map<Object,Object> readDoc(List<String> head) throws Exception;
	public List<Object> MapToList(List<String> head) throws Exception;
	public List<String> getListName() throws Exception;
	public List<Integer> getListKey() throws Exception;
	public List<Object> getListValues() throws Exception;
	public Object getMemberByEmployedCode(Integer key) throws Exception;
	public List<Object> getListMemberByEmployedCode(List<Integer> employedCodenotFindInL2) throws Exception;
	public List<Object> getListMember() throws Exception;
	
	public boolean thereAreDuplicates() throws Exception;
	public List<Object> getListMemberDuplicate() throws Exception;
	public boolean thereAreMemberWithOutEmpledCode()throws Exception;
	public List<Object> getListMemberWithOutEmpledCode() throws Exception;
	public boolean thereAregetListMembertWhithOutCommunity()throws Exception;
	public List<Object> getListMembertWithOutCommunity() throws Exception;
}
