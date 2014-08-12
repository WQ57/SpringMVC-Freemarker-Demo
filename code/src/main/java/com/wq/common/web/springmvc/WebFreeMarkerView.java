package com.wq.common.web.springmvc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * freemarker统一渲染输出.
 * 
 * @author qingwu
 * @date 2014-3-20 下午5:32:18
 */
public class WebFreeMarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		model.put("ctx", request.getContextPath());
	}

}
