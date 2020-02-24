package com.inventory.Stock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long itemNo;
	
	private String name;
	private long amount;
	private long inventoryCode;
	
	public Item(/*Long itemNo, */String name, long amount, long inventoryCode) {
		/*this.itemNo=itemNo;*/
		this.name=name;
		this.amount=amount;
		this.inventoryCode=inventoryCode;
	}
	
	public Item() {}
	
	public Long getItemNo() {
		return itemNo;
	}
	public void setItemNo(Long itemNo) {
		this.itemNo=itemNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount=amount;
	}
	
	public long getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(long inventoryCode) {
		this.inventoryCode=inventoryCode;
	}
	
	@Override
	public String toString() {
		return String.format("Item [id=%s]: name_[name=%s], amount_[amount=%s], inventoryCode_[inventoryCode=%s]"
				,itemNo,name,amount,inventoryCode );
	}
}
