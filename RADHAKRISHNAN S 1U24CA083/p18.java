package com.example.itemsubmission;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ItemSubmissionAppApplication {
public static void main(String[] args) {
SpringApplication.run(ItemSubmissionAppApplication.class, args);
}
}
itemController.java
package com.example.itemsubmission.controller;
import com.example.itemsubmission.model.Item;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/items")
public class ItemController {
@PostMapping
public String handleFormSubmit(@ModelAttribute Item item) {
return "Received Item: " + item.getItemId() + ", " + item.getItemName() + ", " +
item.getItemPrice();
}
}
Item.java:
package com.example.itemsubmission.model;
public class Item {
private String itemId;
private String itemName;
private double itemPrice;
public String getItemId() {
return itemId;
}
public void setItemId(String itemId) {
this.itemId = itemId;
}
public String getItemName() {
return itemName;
}
public void setItemName(String itemName) {
this.itemName = itemName;
}
public double getItemPrice() {
return itemPrice;
}
public void setItemPrice(double itemPrice) {
this.itemPrice = itemPrice;
}
}