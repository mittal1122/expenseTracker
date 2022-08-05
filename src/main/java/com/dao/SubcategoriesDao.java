package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SubCategoryBean;

@Repository
public class SubcategoriesDao {

	
	@Autowired
	JdbcTemplate stmt;
	
	public void addsubCategory(SubCategoryBean subcatBean,int userId) {
		System.out.println("dao : "+subcatBean.getCatid());
		System.out.println("dao : "+subcatBean.getSubcat_name());
		stmt.update("insert into subcategories (cat_id,subcat_name,userid) values(?,?,?)",subcatBean.getCatid(),
				subcatBean.getSubcat_name(),userId);
	}
	
	public void admindeletesubCategory(int subcatId) {
		stmt.update("delete from subcategories where subcatid = ? ", new Object[] {subcatId});
	}
}
