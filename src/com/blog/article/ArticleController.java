package com.blog.article;

import com.blog.model.XArticle;
import com.blog.model.XTypenav;
import com.blog.publicservice.PublicService;
import com.jfinal.core.Controller;

public class ArticleController extends Controller {

	PublicService p = new PublicService();

	public void index() {
		setAttr("alist", p.article.articleDList());
		ArticleController.this.articlePublic();
		renderFreeMarker("article.html");
	}

	public void selectArticle() {
		int id = getParaToInt(0);
		XArticle alist = p.article.selectArticleById(id);
		alist.setAViews(alist.getAViews() + 1).setACreatetime(alist.getACreatetime()).update();
		setAttr("a", alist);
		ArticleController.this.articlePublic();
	
		XArticle last = p.article.selectArticleLastById(id);
		XArticle after = p.article.selectArticleAfterById(id);
		
		setAttr("last", last);
		setAttr("after", after);
		renderFreeMarker("detail.html");
	}

	public void searchArticle() {
		String title = getPara("s_title");
		setAttr("alist", p.article.pageArticle(1, 10, title, title, title));
		setAttr("error", title);
		ArticleController.this.articlePublic();
		renderFreeMarker("articleSerch.html");
	}

	public void typeArticle() {
		String id = getPara(0);
		String type = XTypenav.dao.findById(id).getTTypename();
		setAttr("alist", p.article.searchArticleWType(type));
		setAttr("error", type);
		ArticleController.this.articlePublic();
		renderFreeMarker("articleType.html");
	}

	public void articlePublic() {
		setAttr("tlist", p.typeNav.typeNavList());
		setAttr("vlist", p.article.viewsList(1, 10));
		setAttr("rlist", p.article.randArticle());
		renderFreeMarker("public/articlePublic.html");
	}
}
