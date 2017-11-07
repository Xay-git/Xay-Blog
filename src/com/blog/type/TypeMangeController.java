package com.blog.type;

import java.util.HashMap;
import java.util.Map;

import com.blog.model.XArticle;
import com.blog.model.XTypenav;
import com.blog.publicservice.PublicService;
import com.blog.util.LayuiPage;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class TypeMangeController extends Controller{
	Map map = new HashMap();
	PublicService p = new PublicService();
	LayuiPage<XTypenav> layuiPage = new LayuiPage<XTypenav>();
	public void index(){
		renderFreeMarker("typeList.html");
	}
	
	public void showTypes() {
		int pageNumber = getParaToInt("page");
		int pageSize = getParaToInt("limit");
		Page<XTypenav> typePage = p.typeNav.pagetypeNavList(pageNumber, pageSize);
		layuiPage.setCount(typePage.getTotalRow());
		layuiPage.setData(typePage.getList());
		renderJson(layuiPage);	
	}
	
	public void addType(){
		boolean b = getModel(XTypenav.class, "t").save();
		if(b){
			map.put("msg", 1);
		}else{
			map.put("msg", 2);
		}
		renderJson(map);
	}
	
	public void deleteType(){
		int id = getParaToInt(0);
		boolean b = p.typeNav.deleteTypeById(id);
		if(b){
			map.put("msg","删除成功");
		}else{
			map.put("msg","删除失败");
		}
		renderJson(map);
	}
	
	public void getTypeValue() {
		
		renderJson(p.typeNav.typeNavList());
	}
	
	public void editType(){
		boolean b = getModel(XTypenav.class, "t").update();
		if(b){
			map.put("msg", 1);
		}else{
			map.put("msg", "编辑失败");
		}
		renderJson(map);
	}
		
}
