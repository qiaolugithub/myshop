package net.jeeshop.services.front.area.bean;import java.io.Serializable;import java.util.List;public class Area extends net.jeeshop.services.common.Area implements		Serializable {	private static final long serialVersionUID = 1L;	private List<Area> children;// 子集合	public void clear() {		super.clear();		if (children != null) {			for (int i = 0; i < children.size(); i++) {				children.get(i).clear();			}			children.clear();			children = null;		}	}	public List<Area> getChildren() {		return children;	}	public void setChildren(List<Area> children) {		this.children = children;	}	@Override	public String toString() {		return "Area [children=" + children + "]";	}}