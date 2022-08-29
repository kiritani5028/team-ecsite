package jp.co.internous.sunflower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sunflower.model.domain.MstCategory;
import jp.co.internous.sunflower.model.domain.MstProduct;
import jp.co.internous.sunflower.model.form.SearchForm;
import jp.co.internous.sunflower.model.mapper.MstCategoryMapper;
import jp.co.internous.sunflower.model.mapper.MstProductMapper;
import jp.co.internous.sunflower.model.session.LoginSession;

@Controller
@RequestMapping("/sunflower")
public class IndexController {
	
	@Autowired
	MstCategoryMapper mstCategoryMapper;
	
	@Autowired
	MstProductMapper mstProductMapper;
	
	@Autowired
	LoginSession loginSession;
	
	Gson gson = new Gson();

	@RequestMapping("/")
	public String index(Model m) {
		long userId = loginSession.getUserId();
		long tentativeId = loginSession.getTempId();
		if(userId == 0 && tentativeId > -100_000_000L) {
			long tentativeUserId = (long) Math.floor(Math.random() * -900_000_000L) - 100_000_000L;
			loginSession.setTempId(tentativeUserId);
		}
		
		List<MstCategory> categories = mstCategoryMapper.findAll();
		m.addAttribute("categoryJson", gson.toJson(categories));
		
		List<MstProduct> products = mstProductMapper.findAll();
		m.addAttribute("productJson", gson.toJson(products));
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/api/search")
	public String searchApi(@RequestBody SearchForm f) {
		long categoryId = f.getCategoryId();
		
		String[] productName = f.getItemName().split("[\\h]+");
		
		List<MstProduct> products = mstProductMapper.findByCategoryIdAndProductName(categoryId, productName);
		
		return gson.toJson(products);
	}
	
	
}