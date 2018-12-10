package org.shancm.webcase.tokencase.contol;

import org.shancm.webcase.tokencase.util.TokenUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shancm
 * @package org.shancm.webcase.tokencase.contol
 * @description:
 * @date 2018/7/18
 */
@RestController
@RequestMapping("/token")
public class UserControl {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("user")String user, @RequestParam("password")String password, HttpServletRequest request){
		TokenUtil.saveToken(request);
		return "index";
	}
}
