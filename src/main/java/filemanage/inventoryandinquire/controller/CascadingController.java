package filemanage.inventoryandinquire.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filemanage.inventoryandinquire.service.CascadingService;
import filemanage.systemmanage.pojo.SecondryClassFication;

@Controller
@RequestMapping("/cascading")
public class CascadingController {

	@Autowired
	private CascadingService cascadingService;

	/**
	 * 根据一级分类(档案类型)主键查询二级分类名称(问题机构)
	 * 
	 * @param request
	 * @param response
	 * @param pcId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectSecondaryMenu", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody List<SecondryClassFication> selectSecondaryMenu(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("pcId") String pcId) throws Exception {
		return cascadingService.getSecondryClassListByPcId(pcId);
	}
}
