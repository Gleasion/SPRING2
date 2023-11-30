package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.Item2;

public interface ItemMapper2 {

	public void create(Item2 item);

	public List<Item2> list();

	public Item2 read(int itemId);

	public String getPicture(int itemId);

	public String getPicture2(int itemId);

	public void update(Item2 item);

	public void delete(int itemId);

	
	
}
