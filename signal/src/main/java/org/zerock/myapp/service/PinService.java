package org.zerock.myapp.service;


import org.zerock.myapp.domain.PinDTO;
import org.zerock.myapp.exception.ServiceException;

public interface PinService {
	
	public abstract Integer doPin(PinDTO pin) throws ServiceException;
	
} // end interface
