package com.movie.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;
import com.movie.community.service.CommunityService;
import com.movie.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private final CommunityService communityService;

	@GetMapping("/list")
	public String communityList(@ModelAttribute("params") SearchDto params, Model model) {
		PagingResponse<Community> communityList = communityService.findAll(params);
		model.addAttribute("communityList", communityList);
		return "community/list";
	}
	
	@GetMapping("/{id}")
	public String Community(@PathVariable long id, Model model) {
		Community community = communityService.findById(id);
		model.addAttribute("community", community);
		return "community/info";
	}
	
	@GetMapping("/reg")
	public String regForm() {
		return "community/regForm";
	}
	
	@PostMapping("/reg")
	public String reg(@ModelAttribute Community community) {
		communityService.save(community);
		return "redirect:/community/list";
	}
	
	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable long id, Model model) {
		Community community = communityService.findById(id);
		model.addAttribute("community", community);
		return "community/editForm";
	}
	
	@PostMapping("/{id}/edit")
	public String edit(@PathVariable long id,@ModelAttribute Community community) {
		communityService.update(id, community);
		return "redirect:/community/list";
	}
	
	
}
