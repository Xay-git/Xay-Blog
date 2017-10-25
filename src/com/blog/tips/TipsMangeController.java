package com.blog.tips;

import java.util.HashMap;
import java.util.Map;

import com.blog.model.XArticle;
import com.blog.model.XTips;
import com.blog.model.XTypenav;
import com.blog.publicvar.PublicVar;
import com.blog.util.LayuiPage;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class TipsMangeController extends Controller{
	Map map = new HashMap();
	PublicVar p = new PublicVar();
	LayuiPage<XTips> layuiPage = new LayuiPage<XTips>();
	public void index(){
		renderFreeMarker("tipsList.html");
	}
	
	public void showTips() {
		int pageNumber = getParaToInt("page");
		int pageSize = getParaToInt("limit");
		Page<XTips> tipsList = p.tips.pageTipsList(pageNumber, pageSize);
		layuiPage.setCount(tipsList.getTotalRow());
		layuiPage.setData(tipsList.getList());
		renderJson(layuiPage);	
	}
	
	public void addTips(){
		int sort = getParaToInt("t_sort");
		String content = getPara("t_content");
	
		if((p.tips.findTipsBySort(sort))!=null){
			map.put("msg","排序值已存在");
		}else{
			XTips xtips = new XTips();
            xtips.setTContent(content).setTSort(sort).save();
			map.put("msg", 1);
		}
		renderJson(map);	 
	}
	
	public void deleteTips(){
		int id = getParaToInt(0);
		if(p.tips.deleteTipsById(id)){
			map.put("msg","删除成功");
		}else{
			map.put("msg","删除失败");
		}
		renderJson(map);
	}
	
	public void editTips() {
		XTips tips = new XTips();
		XTips x = getModel(XTips.class, "t");// 获得要修改的数据
		int x_id = x.getTId(); int x_sort = x.getTSort();
		int sort1 = tips.findById(x_id).getTSort();
		XTips sorts = p.tips.findTipsBySort(x_sort);
		if (sorts == null) {
			x.update();
		} else if ((x_id != (sorts.getTId())) && ((sorts != null))) {
			tips.setTId(sorts.getTId()).setTSort(sort1).update();
			x.update();
		} else {
			x.update();
		}
        map.put("msg", 1);
		renderJson(map);
	}
	
}
