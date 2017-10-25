package com.blog.ueditor;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.upload.UploadFile;


public class UEditorController extends Controller{
	public void index() {
		renderFreeMarker("/assets/ueditor/index.html");
	}

	// 处理上传的图片，返回json判断是否上传成功
	public void upload() throws Exception {

		if ("config".equals(getPara("action"))) {
			// 这里千万注意 "config.json" 文件前方的目录一定要正确
			render("/assets/ueditor/jsp/config.json");
			return;
		}

		// "upfile" 来自 config.json 中的 imageFieldName 配置项
		UploadFile uf = getFile("upfile");
		String fileName = uf.getFileName();
		String[] typeArr = fileName.split("\\.");
		Ret ret = Ret.create("state", "SUCCESS")
                .set("url", "/upload/" + fileName)//其中jfinal_demo 是项目名
                .set("title", fileName)
                .set("original", uf.getOriginalFileName())
                .set("type", "." + typeArr[1]) // 这里根据实际扩展名去写
				.set("size", uf.getFile().length());

		renderJson(ret);
	}

	// 包括图片、标题、内容在内全部储存到数据库中
	public void uploadAll() {
		String title = getPara("news.title");
		// UEditor通过getModel接收不到编辑器主体内容editorValue
		String editorValue = getPara("editorValue");

		// 直接使用News().set修改数据库，数据库中id自增
		renderJson(title+editorValue);
//		News news = new News().set("title", title).set("content", editorValue);
//		news.save();
//
//		setAttr("fontValue", news);
//		// 编辑器提交内容后立刻查看
//		renderJsp("/pages/utf8-jsp/news.jsp");
	}



}
