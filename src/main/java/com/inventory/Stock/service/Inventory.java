package com.inventory.Stock.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.Stock.Item;

//import java.util.List;

public interface Inventory extends JpaRepository<Item, Long>{
	//List<Item> getAllStock();

}
