package com.tanmay.service;

import com.tanmay.entity.Tree;

public interface TreeService {

	public Tree findOne(Integer id);
	public Tree updateTree(Tree tree);
	public void deleteTree(Integer id);
	public Tree createTree(Tree tree);
}
