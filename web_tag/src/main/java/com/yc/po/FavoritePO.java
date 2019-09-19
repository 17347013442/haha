package com.yc.po;

import java.io.Serializable;

public class FavoritePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3699555344117069324L;

	private Integer fId;
	private String	fLabel;//网站名
	private String 	fUrl;//地址
	private String 	fTags;//标签名，多个
	private String 	fDesc;//描述
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public String getfLabel() {
		return fLabel;
	}
	public void setfLabel(String fLabel) {
		this.fLabel = fLabel;
	}
	public String getfUrl() {
		return fUrl;
	}
	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}
	public String getfTags() {
		return fTags;
	}
	public void setfTags(String fTags) {
		this.fTags = fTags;
	}
	public String getfDesc() {
		return fDesc;
	}
	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}
	@Override
	public String toString() {
		return "FavoritePO [fId=" + fId + ", fLabel=" + fLabel + ", fUrl=" + fUrl + ", fTags=" + fTags + ", fDesc="
				+ fDesc + "]";
	}
}
