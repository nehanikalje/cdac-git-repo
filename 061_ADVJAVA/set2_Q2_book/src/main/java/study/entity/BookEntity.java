package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book12")
public class BookEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	
	@Column
	private int cost;
	
	@Column
	private String bookName;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookEntitty [bookId=" + bookId + ", cost=" + cost + ", bookName=" + bookName + "]";
	}
	
	public BookEntity(int bookId, int cost, String bookName) {
		super();
		this.bookId = bookId;
		this.cost = cost;
		this.bookName = bookName;
	}

	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
