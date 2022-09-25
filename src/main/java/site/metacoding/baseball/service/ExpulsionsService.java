package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.expulsions.Expulsions;
import site.metacoding.baseball.domain.expulsions.ExpulsionsDao;
import site.metacoding.baseball.web.dto.request.expulsions.ExpulsionsDto;


@RequiredArgsConstructor
@Service
public class ExpulsionsService {
	
	private final ExpulsionsDao expulsionsDao;
	
	public void 퇴출선수등록(ExpulsionsDto expulsionsDto) {	

	}
	
	public List<Expulsions> 퇴출선수목록보기() {	
		List<Expulsions> expulsionsList = expulsionsDao.findAll();
		return expulsionsList;
	}

}
