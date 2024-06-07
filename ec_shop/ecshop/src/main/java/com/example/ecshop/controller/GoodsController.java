package com.example.ecshop.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecshop.Repository.GoodsRepository;
import com.example.ecshop.entity.Goods;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	private final GoodsRepository goodsRepository;

	public GoodsController(GoodsRepository goodsRepository) {
		this.goodsRepository = goodsRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "price", required = false) Integer price,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<Goods> goodsPage;

		if (keyword != null && !keyword.isEmpty()) {
			goodsPage = goodsRepository.findByNameLike("%" + keyword + "%", pageable);
		} else if (area != null && !area.isEmpty()) {

			goodsPage = goodsRepository.findByPriceLessThanEqual(price, pageable);
		} else {
			goodsPage = goodsRepository.findAll(pageable);
		}

		model.addAttribute("goodsPage", goodsPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("area", area);
		model.addAttribute("price", price);

		return "goods/index";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Goods goods = goodsRepository.getReferenceById(id);
		model.addAttribute("goods", goods);
		return "goods/show";
	}

	@GetMapping("/")
	public String getGoods(Model model) {
		List<Goods> goodsList = goodsRepository.findAll();
		model.addAttribute("goodsList", goodsList);
		return "index"; // "index.html" テンプレートをレンダリングする
	}
}
