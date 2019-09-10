package org.dxc.ngoi.order.mapping;

public class OrderMappingResponse {
	
	String outputDoc;	
	String statusCode;
	String statusDesc;
	
	public String getOutputDoc() {
		return outputDoc;
	}
	public void setOutputDoc(String outputDoc) {
		this.outputDoc = outputDoc;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}
