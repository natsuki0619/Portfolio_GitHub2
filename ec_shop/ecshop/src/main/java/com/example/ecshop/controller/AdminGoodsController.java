package com.example.ecshop.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ecshop.Repository.GoodsRepository;
import com.example.ecshop.entity.Goods;
import com.example.ecshop.form.GoodsEditForm;
import com.example.ecshop.form.GoodsRegisterForm;
import com.example.ecshop.service.GoodsService;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	private final GoodsRepository goodsRepository;
	private final GoodsService goodsService;

	public AdminGoodsController(GoodsRepository goodsRepository, GoodsService goodsService) {
		this.goodsRepository = goodsRepository;
		this.goodsService = goodsService;
	}

	@GetMapping
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		Page<Goods> goodsPage = goodsRepository.findAll(pageable);

		model.addAttribute("goodsPage", goodsPage);

		return "admin/goods/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		Goods goods = goodsRepository.getReferenceById(id);

		model.addAttribute("goods", goods);

		return "admin/goods/show";
	}

	// 商品登録
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("goodsRegisterForm", new GoodsRegisterForm()); // Corrected attribute name

		return "admin/goods/register";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute @Validated GoodsRegisterForm goodsRegisterForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/goods/register";
		}

		goodsService.create(goodsRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "商品を登録しました。");

		return "redirect:/admin/goods";
	}

	// 商品編集
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		Goods goods = goodsRepository.getReferenceById(id);
		String imageName = goods.getImageName();
		GoodsEditForm goodsEditForm = new GoodsEditForm(goods.getId(), goods.getName(), null, goods.getDescription(),
				goods.getPrice(), goods.getStock(), goods.getCategoryId());
		model.addAttribute("imageName", imageName);
		model.addAttribute("goodsEditForm", goodsEditForm);

		return "admin/goods/edit";
	}

	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated GoodsEditForm goodsEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/goods/edit";
		}

		goodsService.update(goodsEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "商品情報を編集しました。");

		return "redirect:/admin/goods";
	}

	// 商品削除
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		goodsRepository.deleteById(id);

		redirectAttributes.addFlashAttribute("successMessage", "商品を削除しました。");

		return "redirect:/admin/goods";
	}
}
