package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {

	/**
	 * 需求:根据id查询商品数据
	 * @param itemId
	 * @return TbItem对象
	 */
	public TbItem findItemById(Long itemId); 
	
	
	/**
	 * 需求:分页查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageBeanResult findItemByPage(Integer page,Integer rows);
	
}
