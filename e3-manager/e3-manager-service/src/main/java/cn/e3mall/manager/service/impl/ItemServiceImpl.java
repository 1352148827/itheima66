package cn.e3mall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.manager.service.ItemService;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.utils.PageBeanResult;

@Service
public class ItemServiceImpl implements ItemService {

	/**
	 * 商品mapper代理接口对象
	 */
	@Autowired
	private TbItemMapper itemMapper;
	
	/**
	 * 需求:根据id查询商品数据
	 * @param itemId
	 * @return TbItem对象
	 */
	@Override
	public TbItem findItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	/**
	 * 需求:分页查询商品列表
	 * 分页方法:使用pageHelper插件分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public PageBeanResult findItemByPage(Integer page, Integer rows) {
		// 创建TBItem对象
		TbItemExample example = new TbItemExample();
		
		// 在查询之前,必须先设置分页
		PageHelper.startPage(page, rows);
		
		// 执行查询,自动生成limit,count
		List<TbItem> list = itemMapper.selectByExample(example);
		
		// 创建PageInfo对象,这个对象封装了分页数据
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		
		// 创建分页返回值包装类对象
		PageBeanResult result = new  PageBeanResult();
		
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
