package com.ci2.sgth.people.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci2.sgth.people.domain.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
