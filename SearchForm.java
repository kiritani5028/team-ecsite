package jp.co.internous.sunflower.model.form;

import java.io.Serializable;

public class SearchForm implements Serializable {
	private static final long serialVersionUID = -5831094606176229646L;
	
	private long categoryId;
	private String itemName;
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
