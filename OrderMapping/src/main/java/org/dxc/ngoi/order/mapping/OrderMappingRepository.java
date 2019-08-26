package org.dxc.ngoi.order.mapping;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderMappingRepository extends JpaRepository<Xslts, String> {
	
		
	Xslts findBySourceAndTarget(String source,String target);
	

}
