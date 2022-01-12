package study.dao;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.MyRepository;
import study.entity.BookEntity;

@Service
public class BookDAOBean {
  
	@Autowired
	MyRepository repo;
	
	public void addBook(int id, int cost, String name)
	{
		BookEntity be = new BookEntity(id,cost,name);
		repo.save(be);
	}

	public List<BookEntity> getBooks()
	{
		return repo.findAll();
	}
	
	
}
