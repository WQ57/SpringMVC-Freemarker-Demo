package com.wq.common.web.springmvc;

import java.sql.Timestamp;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.wq.common.web.springmvc.editor.CustomTimestampEditor;
import com.wq.common.web.springmvc.editor.HtmlFilterDoubleEditor;
import com.wq.common.web.springmvc.editor.HtmlFilterIntegerEditor;
import com.wq.common.web.springmvc.editor.HtmlFilterLongEditor;
import com.wq.common.web.springmvc.editor.StringEditor;

/**
 * springMVC数据传参和输出绑定.
 * 
 * @author qingwu
 * @date 2014-3-20 下午5:36:10
 */
public class BindingInitializer implements WebBindingInitializer{

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Long.class, new HtmlFilterLongEditor());
		binder.registerCustomEditor(long.class, new HtmlFilterLongEditor());
		binder.registerCustomEditor(Integer.class, new HtmlFilterIntegerEditor());
		binder.registerCustomEditor(int.class, new HtmlFilterIntegerEditor());
		binder.registerCustomEditor(Double.class, new HtmlFilterDoubleEditor());
		binder.registerCustomEditor(double.class, new HtmlFilterDoubleEditor());
		binder.registerCustomEditor(String.class, new StringEditor());
		binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor("yyyy-MM-dd HH:mm:ss",true));
	}

}
