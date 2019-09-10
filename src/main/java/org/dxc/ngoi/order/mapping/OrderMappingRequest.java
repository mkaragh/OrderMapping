package org.dxc.ngoi.order.mapping;

public class OrderMappingRequest {
	
	String orderDoc;
	String sourceFormat;
	String targetFormat;
	public String getOrderDoc() {
		return orderDoc;
	}
	public void setOrderDoc(String orderDoc) {
		this.orderDoc = orderDoc;
	}
	public String getSourceFormat() {
		return sourceFormat;
	}
	public void setSourceFormat(String sourceFormat) {
		this.sourceFormat = sourceFormat;
	}
	public String getTargetFormat() {
		return targetFormat;
	}
	public void setTargetFormat(String targetFormat) {
		this.targetFormat = targetFormat;
	}
	

}
