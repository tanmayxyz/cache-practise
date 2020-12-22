package com.tanmay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanmay.entity.Tree;
import com.tanmay.service.TreeService;

@RestController
public class TreeController {

	@Autowired
	private TreeService treeService;
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/tree/{id}")
	public Tree getTree(@PathVariable("id") Integer id) {
		return treeService.findOne(id);
	}
	@PostMapping("/tree")
	public String createTree(@RequestBody Tree tree) {
		treeService.createTree(tree);
		return messageSource.getMessage("tree.created", null, null);
	}
	
	@PutMapping("/tree")
	public String updatedTree(@RequestBody Tree tree) {
		treeService.updateTree(tree);
		return messageSource.getMessage("tree.updated", null, null);
	}
	
	@DeleteMapping("/tree/{id}")
	public String deleteTree(@PathVariable("id")Integer id) {
		treeService.deleteTree(id);
		return messageSource.getMessage("tree.deleted", null, null);
	}
	
}
