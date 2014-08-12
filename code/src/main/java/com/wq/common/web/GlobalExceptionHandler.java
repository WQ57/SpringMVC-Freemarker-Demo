package com.wq.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wq.common.util.Jackson2Util;
import com.wq.common.util.ObjectUtil;
import com.wq.common.util.UnCaughtException;

/**
 * 全局异常处理.
 * 
 * @author qingwu
 * @date 2014-2-8 下午5:53:23
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	/**
	 * 日志.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(GlobalExceptionHandler.class);

	/**
	 * response编码.
	 */
	private String contentType;

	/**
	 * 404页面.
	 */
	private String errorUrl;

	/**
	 * 处理全局异常.
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		try {
			String url = request.getRequestURI();
			LOGGER.error(
					"发生错误http错误码为 : {},  errorMsg : {}, 请求地址 : {}",
					new Object[] {
							request.getAttribute("javax.servlet.error.status_code"),
							ex.getMessage(), url });
			// 异常针对处理
			if (ex instanceof UnCaughtException) {
				LoggerFactory.getLogger(handler.getClass()).error(
						url + "|系统异常:" + ex, ex);
			} else {
				LoggerFactory.getLogger(handler.getClass()).error(
						url + "|未知异常:" + ex, ex);
			}
			if (!ObjectUtil.isEmpty(request.getHeader("X-Requested-With"))) {// ajax请求
				Response<Boolean> globalResponse = ResponseFactory
						.getDefaultFailureResponse();
				globalResponse.setData(false);
				globalResponse
						.setMessage("The request could not be completed, server invoke error.");
				Jackson2Util.writeJson(response, globalResponse);
				return new ModelAndView();
			} else {// 页面跳转
				return new ModelAndView(errorUrl);
			}
		} catch (Throwable e) {
			return new ModelAndView(errorUrl);
		}
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the errorUrl
	 */
	public String getErrorUrl() {
		return errorUrl;
	}

	/**
	 * @param errorUrl
	 *            the errorUrl to set
	 */
	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

}
