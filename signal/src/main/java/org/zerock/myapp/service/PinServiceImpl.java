package org.zerock.myapp.service;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.PinDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.PinMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Service("PinService")
public class PinServiceImpl 
	implements 
		PinService,
		InitializingBean,
		DisposableBean {

	@Setter(onMethod_= {@Autowired} )
	private PinMapper pinMapper;

	@Override
	public Integer doPin(PinDTO pin) throws ServiceException {
		log.trace("doPin() asdsaddassaddasdas.");
		
		try {
			
			if(this.pinMapper.checkPin(pin) == 0){
				return this.pinMapper.insert(pin);
			} else {
				PinDTO dto = this.pinMapper.select(pin.getPostNo(),pin.getNickName());
				return this.pinMapper.delete(dto.getPinNo())-1;
			} // if-else
		}catch(Exception e) {
			throw new ServiceException(e);
		} // try-catch


//	====== IntitializingBean, DisposableBean ======

	@Override
	public void afterPropertiesSet() throws Exception {
		log.trace("afterPropertiesSet() invoked.");
		
	} // afterPropertiesSet

	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
		
	} // destroy

} // end class
