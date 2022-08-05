package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;

	public void addCategory(CategoryBean catBean) {
		stmt.update("insert into categories(cat_name,userid) values(?,?)", catBean.getCat_name(), catBean.getUserid());
	}

	public List<CategoryBean> categoryList(int userId) {

		List<CategoryBean> category = stmt.query("select * from categories where userid = ? or userid = 3",
				new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class), new Object[] { userId });

		return category;
	}


	public void admindeleteCategory(int catid) {
		
		stmt.update("delete from expense where catid = ?",new Object[] {catid});
		stmt.update("delete from subcategories where cat_id = ?",new Object[] {catid});
		stmt.update("delete from categories where catid = ?",new Object[] {catid});
	}
	
	public List<SubCategoryBean> subcategoryList(int catId) {

		List<SubCategoryBean> subcategory = stmt.query("select * from subcategories where cat_id = ? ",
				new BeanPropertyRowMapper<SubCategoryBean>(SubCategoryBean.class), new Object[] { catId });

		return subcategory;
	}
	
	
}