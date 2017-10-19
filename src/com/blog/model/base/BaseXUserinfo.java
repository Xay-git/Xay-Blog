package com.blog.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseXUserinfo<M extends BaseXUserinfo<M>> extends Model<M> implements IBean {

	public M setIId(java.lang.Integer iId) {
		set("i_id", iId);
		return (M)this;
	}

	public java.lang.Integer getIId() {
		return getInt("i_id");
	}

	public M setIUsername(java.lang.String iUsername) {
		set("i_userName", iUsername);
		return (M)this;
	}

	public java.lang.String getIUsername() {
		return getStr("i_userName");
	}

	public M setISex(java.lang.String iSex) {
		set("i_sex", iSex);
		return (M)this;
	}

	public java.lang.String getISex() {
		return getStr("i_sex");
	}

	public M setIAge(java.lang.String iAge) {
		set("i_age", iAge);
		return (M)this;
	}

	public java.lang.String getIAge() {
		return getStr("i_age");
	}

	public M setIImgpath(java.lang.String iImgpath) {
		set("i_imgPath", iImgpath);
		return (M)this;
	}

	public java.lang.String getIImgpath() {
		return getStr("i_imgPath");
	}

	public M setIGithub(java.lang.String iGithub) {
		set("i_github", iGithub);
		return (M)this;
	}

	public java.lang.String getIGithub() {
		return getStr("i_github");
	}

	public M setIQq(java.lang.String iQq) {
		set("i_qq", iQq);
		return (M)this;
	}

	public java.lang.String getIQq() {
		return getStr("i_qq");
	}

}