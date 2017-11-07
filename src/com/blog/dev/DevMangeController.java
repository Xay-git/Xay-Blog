package com.blog.dev;

import java.util.HashMap;
import java.util.Map;

import com.blog.model.XAdmindev;
import com.blog.model.XArticle;
import com.blog.model.XDev;
import com.blog.model.XTips;
import com.blog.publicservice.PublicService;
import com.blog.util.LayuiPage;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class DevMangeController extends Controller{
	Map map = new HashMap();
	PublicService p = new PublicService();
	public void index(){
		renderFreeMarker("devList.html");
	}
	
	public void devList(){
		int pageNumber = getParaToInt("page");
		int pageSize = getParaToInt("limit");
		Page<XDev> devList = p.dev.pageDevList(pageNumber, pageSize);
		LayuiPage<XDev> layuiPage = new LayuiPage<XDev>();
		layuiPage.setCount(devList.getTotalRow());
		layuiPage.setData(devList.getList());
		renderJson(layuiPage);	
	}
	
	public void addDev(){
		boolean b = getModel(XDev.class,"d").save();
        if(b){
        	map.put("msg", 1);
        }else{
        	map.put("msg", "添加失败，请检查输入是否有误");
        }
        renderJson(map);
	}
	
	public void editDev(){
		boolean b = getModel(XDev.class,"d").update();
		if(b){
			map.put("msg", 1);
		}else{
			map.put("msg", "编辑失败，请检查输入是否有误");
		}
		renderJson(map);
	}
	
	public void deleteDev(){
		int id = getParaToInt(0);
		boolean b = XDev.dao.deleteById(id);
		if(b){
			map.put("msg","删除成功");
		}else{
			map.put("msg","删除失败");
		}
		renderJson(map);
		}
	
	
	public void adminDevList() {
		int pageNumber = getParaToInt("page");
		int pageSize = getParaToInt("limit");
		Page<XAdmindev> adminDevList = p.adminDev.pageAdminDevList(pageNumber, pageSize);
		LayuiPage<XAdmindev> layuiPage = new LayuiPage<XAdmindev>();
		layuiPage.setCount(adminDevList.getTotalRow());
		layuiPage.setData(adminDevList.getList());
		renderJson(layuiPage);
	}
	
	public void addAdminDev(){
		boolean b = getModel(XAdmindev.class,"a").save();
        if(b){
        	map.put("msg", 1);
        }else{
        	map.put("msg", "添加失败，请检查输入是否有误");
        }
        renderJson(map);
	}
	
	public void editAdminDev(){
		boolean b = getModel(XAdmindev.class,"a").update();
		if(b){
			map.put("msg", 1);
		}else{
			map.put("msg", "编辑失败，请检查输入是否有误");
		}
		renderJson(map);
	}
	
	public void deleteAdminDev(){
		int id = getParaToInt(0);
		boolean b = XAdmindev.dao.deleteById(id);
		if(b){
			map.put("msg","删除成功");
		}else{
			map.put("msg","删除失败");
		}
		renderJson(map);
		}
	

}
