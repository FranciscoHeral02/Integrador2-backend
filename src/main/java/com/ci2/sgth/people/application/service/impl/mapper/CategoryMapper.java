package com.ci2.sgth.people.application.service.impl.mapper;


import com.ci2.sgth.people.domain.dto.CategoryDto;
import com.ci2.sgth.people.domain.entity.Category;
import com.ci2.sgth.people.domain.entity.Job;

public class CategoryMapper {

	public static CategoryDto mapToDto(Category entity) {
		
		CategoryDto dto = CategoryDto.builder()
							.categoryId(entity.getCategoryId())
							.job(entity.getJob())
							.nombreCategoria(entity.getNombreCategoria())
							.pagoHora(entity.getPagoHora())
							.build();
		
		return dto;
							
		
	}
	
	public static Category mapToEntity(CategoryDto dto) {
		
		Category entity = Category.builder()
				.categoryId(dto.getCategoryId())
				.job(Job.builder().jobId(dto.getJobId()).build())
				.nombreCategoria(dto.getNombreCategoria())
				.pagoHora(dto.getPagoHora())
				.build();

		return entity;
		
	}
}
