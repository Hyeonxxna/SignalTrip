package org.zerock.myapp.mapper;


import java.util.List;
import org.zerock.myapp.domain.PinDTO;

public interface PinMapper {
	
	public abstract Integer insert(PinDTO pin) throws Exception;
	
	public abstract Integer delete(Integer pinNo);
	
	public abstract PinDTO select(Integer postNo, String nickName);
	
//	회원정보와 게시글 정보를 넘겨서 해당 row가 있는지 확인
	public abstract Integer checkPin(PinDTO pin);
	
} // end interface
