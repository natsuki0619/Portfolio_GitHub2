package com.example.ecshop.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoodsEditForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "商品名を入力してください。")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "説明文を入力してください。")
	private String description;

	@NotNull(message = "価格を入力してください。")
	@Min(value = 1, message = "商品価格は1円以上に設定してください。")
	private Integer price;

	@NotNull(message = "在庫数を入力してください。")
	@Min(value = 1, message = "在庫数は1個以上に設定してください。")
	private Integer stock;

	@NotNull(message = "カテゴリを選択してください。")
	private Integer categoryId;
}