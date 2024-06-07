package com.example.ecshop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecshop.Repository.GoodsRepository;
import com.example.ecshop.entity.Goods;
import com.example.ecshop.form.GoodsEditForm;
import com.example.ecshop.form.GoodsRegisterForm;

@Service
public class GoodsService {

	private final GoodsRepository goodsRepository;

	public GoodsService(GoodsRepository goodsRepository) {
		this.goodsRepository = goodsRepository;
	}

	// 商品登録
	@Transactional
	public void create(GoodsRegisterForm goodsRegisterForm) {
		Goods goods = new Goods();
		MultipartFile imageFile = goodsRegisterForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			goods.setImageName(hashedImageName);
		}

		goods.setName(goodsRegisterForm.getName());
		goods.setDescription(goodsRegisterForm.getDescription());
		goods.setPrice(goodsRegisterForm.getPrice());
		goods.setStock(goodsRegisterForm.getStock());
		goods.setCategoryId(goodsRegisterForm.getCategoryId());

		goodsRepository.save(goods);
	}

	// 商品更新
	@Transactional
	public void update(GoodsEditForm goodsEditForm) {
		Goods goods = goodsRepository.getReferenceById(goodsEditForm.getId());
		MultipartFile imageFile = goodsEditForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			goods.setImageName(hashedImageName);
		}

		goods.setName(goodsEditForm.getName());
		goods.setDescription(goodsEditForm.getDescription());
		goods.setPrice(goodsEditForm.getPrice());
		goods.setStock(goodsEditForm.getStock());
		goods.setCategoryId(goodsEditForm.getCategoryId());

		goodsRepository.save(goods);
	}

	// UUIDを使って生成したファイル名を返す
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");
		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);
		return hashedFileName;
	}

	// 画像ファイルを指定したファイルにコピーする
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
