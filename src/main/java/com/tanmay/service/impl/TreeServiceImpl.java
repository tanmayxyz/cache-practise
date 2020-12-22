package com.tanmay.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.tanmay.entity.Tree;
import com.tanmay.exception.NotFoundException;
import com.tanmay.repository.TreeRepository;
import com.tanmay.service.TreeService;

@Service
@Transactional
public class TreeServiceImpl implements TreeService {

	@Autowired
	private TreeRepository repo;
	@Autowired
	private MessageSource messageSource;
	
	@Override
	@Cacheable(cacheNames = "trees",key = "#id")
	public Tree findOne(Integer id) {
		System.out.println("searching in database");
		return repo.findById(id).orElseThrow(() -> 
		new NotFoundException(messageSource.getMessage("tree.not-found", null, null)));
	}

	@Override
	@CachePut(cacheNames = "trees",key = "#tree.id")
	public Tree updateTree(Tree tree) {
	repo.findById(tree.getId()).orElseThrow(() -> new NotFoundException("gamer"));
		System.out.println("hello");
		return repo.save(tree);

	}

	@Override
	@CacheEvict(cacheNames = "trees",key = "#id")
	public void deleteTree(Integer id) {
		if(!repo.findById(id).isPresent()) {
			throw new NotFoundException(
					messageSource.getMessage("tree.not-found", null, null));
		}
		
		 repo.deleteById(id);

	}

	@Override
	@CachePut(cacheNames = "trees",key = "#tree.id")
	public Tree createTree(Tree tree) {
		System.out.println("hello");
		return repo.save(tree);
		

	}

}
