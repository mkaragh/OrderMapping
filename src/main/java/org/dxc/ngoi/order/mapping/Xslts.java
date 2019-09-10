package org.dxc.ngoi.order.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "XSLTS")
public class Xslts {
	
	@Id   
	@Column(name = "XSLT_ID") 
	private String xsltId;
	 
	@Column(name = "SOURCE") 
	private String source;
	
	@Column(name = "TARGET")
	private String target;
	
	@Column(name = "XSLT")
	private String xslt;

	public String getXslt() {
		return xslt;
	}

	public void setXslt(String xslt) {
		this.xslt = xslt;
	}

	public Integer getXsltId() {
		return xsltId;
	}

	public void setXsltId(Integer xsltId) {
		this.xsltId = xsltId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	

}
