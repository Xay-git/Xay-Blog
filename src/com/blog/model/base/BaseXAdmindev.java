package com.blog.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseXAdmindev<M extends BaseXAdmindev<M>> extends Model<M> implements IBean {

	public M setDId(java.lang.Integer dId) {
		set("d_id", dId);
		return (M)this;
	}

	public java.lang.Integer getDId() {
		return getInt("d_id");
	}

	public M setDTime(java.util.Date dTime) {
		set("d_time", dTime);
		return (M)this;
	}

	public java.util.Date getDTime() {
		return get("d_time");
	}

	public M setDLog(java.lang.String dLog) {
		set("d_log", dLog);
		return (M)this;
	}

	public java.lang.String getDLog() {
		return getStr("d_log");
	}

}
