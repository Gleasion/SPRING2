package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.Item;

public interface ItemMpper {

	public void create(Item item);

	public List<Item> list();

	public Item read(int itemId);

	public String getPicture(int itemId);

	public void update(Item item);

	public void delete(int itemId);

}
