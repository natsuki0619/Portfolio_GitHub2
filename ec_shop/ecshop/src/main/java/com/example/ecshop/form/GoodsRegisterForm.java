package com.example.ecshop.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsRegisterForm {
	@NotBlank(message = "商品名を入力してください。")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "説明文を入力してください。")
	private String description;

	@NotNull(message = "価格を入力してください。")
	private Integer price;

	@NotNull(message = "在庫数を入力してください。")
	private Integer stock;

	@NotNull(message = "カテゴリを選択してください。")
	private Integer categoryId;
}
