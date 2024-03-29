package com.wq.common.web.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring mvc 默认地址匹配.
 * 
 * @author qingwu
 * @date 2013-6-1 下午4:35:02
 */
public class WildcardMVCController {

	/**
	 * 默认匹配所有地址.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2013-4-15 下午2:16:00
	 */
	@RequestMapping("/**/*.htm")
	public ModelAndView htmMapping(HttpServletRequest request,
			HttpServletResponse response) {
		String url = request.getServletPath();
		ModelAndView view = new ModelAndView();
		view.setViewName(getViewName(url, ".htm"));
		return view;
	}

	/**
	 * 默认匹配所有地址.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2013-4-15 下午2:16:00
	 */
	@RequestMapping("/**/*.html")
	public ModelAndView htmlMapping(HttpServletRequest request,
			HttpServletResponse response) {
		String url = request.getServletPath();
		ModelAndView view = new ModelAndView();
		view.setViewName(getViewName(url, ".html"));
		return view;
	}

	/**
	 * 获得视图路径.
	 * 
	 * @param requestURI
	 * @param suffix
	 * @return
	 * @author qingwu
	 * @date 2014-2-10 下午3:36:55
	 */
	public String getViewName(String requestURI, String suffix) {
		String viewName = requestURI;
		viewName = viewName.substring(0, viewName.length() - suffix.length());
		return viewName;
	}

}
