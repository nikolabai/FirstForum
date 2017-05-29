package cn.gavin.dao;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.gavin.domain.Board;

/**
 * 
 * @author lenin
 * @2017年5月28日
 */
@Repository
public class BoardDao extends BaseDao<Board>{
	protected final String GET_BOARD_NUM="select count(f.boardld)from Board f";
	@Autowired
	private HibernateTemplate hibernateTemplate;
	//获取论坛版块数目的方法
	public long getBoardNum(){
		Iterator iterator =hibernateTemplate.iterate(GET_BOARD_NUM );
		return ((Long)iterator.next());
	}
	
}
