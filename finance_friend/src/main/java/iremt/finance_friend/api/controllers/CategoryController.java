package iremt.finance_friend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iremt.finance_friend.business.abstracts.CategoryService;
import iremt.finance_friend.entities.concretes.Category;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/getall")
	public List<Category> getAll(){
		return this.categoryService.getAll();
		
	}
}
