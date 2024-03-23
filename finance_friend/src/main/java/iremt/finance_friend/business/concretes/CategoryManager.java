package iremt.finance_friend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iremt.finance_friend.business.abstracts.CategoryService;
import iremt.finance_friend.dataAccess.abstracts.CategoryDao;
import iremt.finance_friend.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService{
	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.categoryDao.findAll();
	}
	
}

