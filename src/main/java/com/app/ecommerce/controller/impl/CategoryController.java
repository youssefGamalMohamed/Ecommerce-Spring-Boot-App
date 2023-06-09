package com.app.ecommerce.controller.impl;

import com.app.ecommerce.controller.framework.ICategoryController;
import com.app.ecommerce.exception.type.IdNotFoundException;
import com.app.ecommerce.models.request.PostCategoryRequestBody;
import com.app.ecommerce.models.request.PutCategoryRequestBody;
import com.app.ecommerce.service.framework.ICategoryService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController implements ICategoryController {


    @Autowired
    private ICategoryService categoryService;

    @RolesAllowed({"ADMIN"})
    @PostMapping("/categories")
    @Override
    public ResponseEntity<?> addNewCategory(@Valid @RequestBody PostCategoryRequestBody categoryRequestBody) {
        return new ResponseEntity<>(
        		    categoryService.add(categoryRequestBody) ,
        		    HttpStatus.CREATED
        		);
    }

    @RolesAllowed({"ADMIN"})
    @DeleteMapping("/categories/{id}")
    @Override
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long categoryId) throws IdNotFoundException {
    	return new ResponseEntity<>(
    			categoryService.deleteById(categoryId) 
    			, HttpStatus.NO_CONTENT
    		);
    }

    @RolesAllowed({"ADMIN" , "USER"})
    @GetMapping("/categories")
    @Override
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(categoryService.findAll(page,size));
    }

    @RolesAllowed({"ADMIN" , "USER"})
    @GetMapping("/categories/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable("id") Long categoryId) {
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping("/categories/{id}")
    @Override
    public ResponseEntity<?> updateById(@PathVariable("id") Long categoryId , @Valid @RequestBody PutCategoryRequestBody updatedBody) {
        return ResponseEntity.ok(categoryService.updateById(categoryId, updatedBody));
    }



}
