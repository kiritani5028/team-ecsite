package jp.co.internous.sunflower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.sunflower.model.domain.MstUser;
import jp.co.internous.sunflower.model.form.UserForm;
import jp.co.internous.sunflower.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/sunflower/user")
public class UserController {
	
	@Autowired
	MstUserMapper mstUserMapper;
	
	@RequestMapping("/")
	public String index() {
		return "register_user";
	}
	
	@ResponseBody
	@RequestMapping("/duplicationApi")
	public long duplicationApi(@RequestBody UserForm f) {
		String userName = f.getUserName();
		List<MstUser> users = mstUserMapper.findByUserName(userName);
		
		if(users.size() > 0) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public void register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		mstUserMapper.registerUser(user);

	}
}
