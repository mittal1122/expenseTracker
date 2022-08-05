package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.SubcategoriesDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao catDao;
	@Autowired
	SubcategoriesDao subcatDao;

	@GetMapping("/categories")
	public String category() {

		return "AddCategoryUSer";

	}

	@GetMapping("/subcategories")
	public String subCategory(HttpSession session, Model model, @ModelAttribute("category") CategoryBean catBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			int userId = user.getUserId();
			System.out.println("Category Controller ::userId = " + userId);

			List<CategoryBean> Categories = catDao.categoryList(userId);
			System.out.println("category List ::" + Categories);
			model.addAttribute("category", Categories);

			return "AddSubCategoryUser";
		}
	}

	@PostMapping("/categories")
	public String addCategory(Model model, @ModelAttribute("error") CategoryBean catBean, HttpSession session) {

		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			int userId = user.getUserId();
			System.out.println("Category Controller ::userId = " + userId);
			catBean.setUserid(userId);
			if (catBean.getCat_name().equals("")) {
				model.addAttribute("error", "Plese Enter Category");
				return "AddCategoryUSer";
			}
			catDao.addCategory(catBean);
			model.addAttribute("added", "successfully add");
			return "redirect:/categories";
		}
	}

	@PostMapping("/subcategories")
	public String addsubCategory(Model model, @ModelAttribute("error") SubCategoryBean subcatBean,
			HttpSession session) {

		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			int userId = user.getUserId();
			System.out.println("Category Controller ::userId = " + userId);
			if (subcatBean.getCatid() == 0) {
				System.out.println("Controller getCatid: " + subcatBean.getCatid());
				System.out.println("Controller getCatid: " + subcatBean.getSubcat_name());

				model.addAttribute("error", "Plese Enter Category");
				return "AddSubCategoryUser";
			} else if (subcatBean.getSubcat_name() == null) {
				model.addAttribute("error", "Plese Enter SubCategory");
				return "AddSubCategoryUser";
			} else {
				System.out.println("Controller : " + subcatBean.getCatid());
				System.out.println("Controller : " + subcatBean.getSubcat_name());
				subcatDao.addsubCategory(subcatBean,userId);
				return "redirect:/subcategories";
			}

		}
	}

	@GetMapping("/admincategories")
	public String adminCategories() {

		return "AddCategoryUSer";

	}

	@GetMapping("/admincategorieslist")
	public String categoryList(@RequestParam("userid") int userId, Model model, CategoryBean catBean) {

		List<CategoryBean> Categories = catDao.categoryList(userId);
		System.out.println("category List ::" + Categories);
		model.addAttribute("category", Categories);

		return "CategoryList";
	}

	@GetMapping("/deletecategory")
	public String categoryList(@RequestParam("catid") int catid, Model model) {
		System.out.println("catid :: :: " + catid);
		catDao.admindeleteCategory(catid);

		return "redirect:/userlist";
//		return "CategoryList";
	}

	@GetMapping("/categorieslist")
	public String categorylist(HttpSession session, Model model, CategoryBean catBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			int userId = user.getUserId();
			List<CategoryBean> Categories = catDao.categoryList(userId);
			System.out.println("category List ::" + Categories);
			model.addAttribute("category", Categories);

			return "CategoryList";
		}
	}
	
	
	@GetMapping("/subcategorieslist")
	public String subcategorylist(@RequestParam ("catid") int catId,HttpSession session, Model model, CategoryBean catBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			List<SubCategoryBean> subCategories = catDao.subcategoryList(catId);
			model.addAttribute("subcategory", subCategories);

			return "SubcategoryList";
		}
	}
	@GetMapping("/deletesubCategory")
	public String subcategoryList(@RequestParam("subcatid") int subcatid, Model model) {
		System.out.println("catid :: :: " + subcatid);
		subcatDao.admindeletesubCategory(subcatid);

		return "redirect:/userlist";
//		return "CategoryList";
	}
	
}
