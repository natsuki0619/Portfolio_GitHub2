package com.example.ecshop.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "goods")
@Data
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;

}