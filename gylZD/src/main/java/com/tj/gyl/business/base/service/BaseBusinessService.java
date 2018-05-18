package com.tj.gyl.business.base.service;

import java.io.Serializable;

import com.tj.gyl.query.BaseQuery;
import com.tj.gyl.query.PageResult;

/**
 * 关于业务逻辑的抽象接口
 *  参数T代表主表
 *  参数E代表子表
 */
public interface BaseBusinessService<T,E extends Serializable>{
	public PageResult<T> getEntrties_zhu(BaseQuery baseQuery);  //返回主表的分页
	public PageResult<E> getEntrties_zi(BaseQuery baseQuery);  //返回子表的分页
}
