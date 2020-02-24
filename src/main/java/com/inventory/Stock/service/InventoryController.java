package com.inventory.Stock.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventory.Stock.Item;

// Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class InventoryController {
	
	@Autowired
	private Inventory inventory;
	
//	@Override
//	public void run(String... arg0) throws Exception {
//		
//	}
	
	@GetMapping(path="/stock")
	public List<Item> getStock() {
		return inventory.findAll();
	}
	
	@GetMapping(path="/stock/{itemNo}")
	public Item getItem(@PathVariable long itemNo) {
		return inventory.findById(itemNo).get();
	}
	
	@DeleteMapping(path="/stock/{itemNo}")
	public ResponseEntity<Void> deleteItem(@PathVariable long itemNo) {
		inventory.deleteById(itemNo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/stock/{itemNo}")
	public ResponseEntity<Item> updateItem(@PathVariable long itemNo, @RequestBody Item item) {
		Item itemUpdated=inventory.save(item);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@PutMapping(path="/stock/increase/{itemNo}")
	public ResponseEntity<Void> increaseItem(@PathVariable long itemNo) {
		Item item=inventory.findById(itemNo).get();
		item.setAmount(item.getAmount()+1);
		Item itemUpdated=inventory.save(item);		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/stock/decrease/{itemNo}")
	public ResponseEntity<Void> decreaseItem(@PathVariable long itemNo) {
		Item item=inventory.findById(itemNo).get();
		item.setAmount(item.getAmount()-1);
		Item itemUpdated=inventory.save(item);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(path="/stock")
	public ResponseEntity<Void> addItem(@RequestBody Item item) {
		Item newItem=inventory.save(item);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{itemNo}").buildAndExpand(newItem.getItemNo()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

