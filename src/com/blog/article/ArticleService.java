package com.blog.article;

import java.util.List;

import com.blog.model.XArticle;
import com.jfinal.plugin.activerecord.Page;

public class ArticleService {

	public static final XArticle dao = new XArticle().dao();
	
	public Page<XArticle> pageArticle(int pageNumber, int pageSize, String msg, String msg1,String msg2) {
		return dao.paginate(pageNumber, pageSize, "select *",
				"from x_article where a_id like ? or a_title like ? or a_type like ? order by a_id desc", "%" + msg + "%", "%" + msg1 + "%","%" + msg2 + "%");
	}
	
	public List<XArticle> articleAList(){
		return dao.find("select * from x_article order by a_id asc");
	}
	
	public List<XArticle> articleDList(){
		return dao.find("select * from x_article order by a_id desc");
	}
	
	public Page<XArticle> pageArticleAList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_article order by a_id desc");
	}
	
	public Page<XArticle> viewsList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_article order by a_views desc");
	}
	
	public Page<XArticle> newArticles(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_article order by a_createTime desc");
	}
	
	public XArticle selectArticleById(int a_id){
		return dao.findById(a_id);
	}
	
	public boolean delectArticleById(int a_id){
		return dao.deleteById(a_id);
	}
	
	public List<XArticle> randArticle(){
		return dao.find("SELECT * FROM x_article  ORDER BY  RAND() LIMIT 6");
	}
	
	public List<XArticle> searchArticleWType(String typeName){
		return dao.find("select * from x_article where a_type = ?",typeName);
	}
}
