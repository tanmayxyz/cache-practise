package com.tanmay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanmay.entity.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Integer> {

}
