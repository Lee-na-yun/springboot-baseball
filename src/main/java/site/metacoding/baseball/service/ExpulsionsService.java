package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.expulsions.Expulsions;
import site.metacoding.baseball.domain.expulsions.ExpulsionsDao;
import site.metacoding.baseball.web.dto.request.expulsions.ExpulsionsDto;
import site.metacoding.baseball.web.dto.response.expulsions.expulsionsListDto;


@RequiredArgsConstructor
@Service
public class ExpulsionsService {
	
	private final ExpulsionsDao expulsionsDao;
	
	public void 퇴출선수등록(ExpulsionsDto expulsionsDto) {	
		Expulsions expulsions = expulsionsDto.toEntity();
		expulsionsDao.insert(expulsionsDto);
	}
	
	
	public List<expulsionsListDto> 퇴출선수목록보기() {	
		List<expulsionsListDto> expulsionsList = expulsionsDao.findAll();
		return expulsionsList;
	}
	

}
