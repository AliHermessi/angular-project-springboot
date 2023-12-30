package com.task.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.models.Categories;


@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
   
}