package com.blog.tips;

import java.util.List;

import com.blog.model.XTips;
import com.jfinal.plugin.activerecord.Page;

public class TipsService {
	
public static final XTips dao = new XTips().dao();
	
		public List<XTips> tipsList(){
			return dao.find("select * from x_tips order by t_sort asc");
		}
		
		public Page<XTips> pageTipsList(int pageNumber,int pageSize){
			return dao.paginate(pageNumber, pageSize, "select *","from x_tips order by t_sort asc");
		}
		
		public XTips findTipsBySort(int sort){
			return dao.findFirst("select * from x_tips where t_sort = ?",sort);
		}
		
		public boolean deleteTipsById(int id){
			return dao.deleteById(id);
		}


}
