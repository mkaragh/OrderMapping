package org.dxc.ngoi.order.mapping;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/order")
public class OrderMappingController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderMappingRepository orderMappingRepository;

	@PostMapping(path="/map") // Map ONLY POST Requests
	public OrderMappingResponse mapOrder (@RequestBody OrderMappingRequest orderMappingRequest) throws Exception {	
		
		OrderMappingResponse orderMappingResponse = new OrderMappingResponse();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	
		
				 
	    //File xml = new File("XCBLinput.xml");
	    
	   // Xslts xslt = orderMappingRepository.findBySourceAndTarget("XCBL", "GSXML");
	    
	    Xslts xslt = orderMappingRepository.findBySourceAndTarget(orderMappingRequest.sourceFormat, orderMappingRequest.getTargetFormat());
	    
	    InputStream stream = new ByteArrayInputStream(xslt.getXslt().getBytes());	 
	    DocumentBuilder builder = factory.newDocumentBuilder();
	  
	    //  Document document = builder.parse(xml);
	    
	    Document document = builder.parse(new InputSource(new StringReader(orderMappingRequest.getOrderDoc())));
	 
	    // Use a Transformer for output
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	   // StreamSource style = new StreamSource(xsl);   
	    
	    
	    StreamSource style = new StreamSource(stream);
	    
	    Transformer transformer = transformerFactory.newTransformer(style);
	 
	    DOMSource source = new DOMSource(document);
	   // StreamResult result = new StreamResult(System.out);
	    StringWriter writer = new StringWriter();
	    StreamResult result = new StreamResult(writer);	    
	    	    
	    transformer.transform(source, result);
	    String outputDoc = writer.toString();
	    orderMappingResponse.setOutputDoc(outputDoc);
	    orderMappingResponse.setStatusCode("200");
	    orderMappingResponse.setStatusDesc("OrderMapping Successful");	    
	    
		return orderMappingResponse;
	}

}
