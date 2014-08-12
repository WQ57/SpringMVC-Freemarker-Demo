package com.wq.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wq.common.web.Response;
import com.wq.dto.TestDTO;

/**
 * 测试控制层.
 * 
 * @author qingwu
 * @date 2014-3-21 上午9:42:55
 */
@Controller
@RequestMapping("test")
public class TestCtrl {

	/**
	 * 页面跳转.
	 * 
	 * @param req
	 * @param res
	 * @return
	 * @author qingwu
	 * @date 2014-1-26 上午11:25:54
	 */
	@RequestMapping("/page")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/test");
		return view;
	}

	/**
	 * ajax请求.
	 * 
	 * @param ermpUserDTO
	 *            查询参数
	 * @return
	 * @author qingwu
	 * @date 2014-1-20 上午10:48:37
	 */
	@RequestMapping("/ajax")
	@ResponseBody
	public Response<TestDTO> queryUser(TestDTO params) {
		Response<TestDTO> r = new Response<TestDTO>();
		r.setData(params);
		return r;
	}
}
