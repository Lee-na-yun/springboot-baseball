package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadiums.Stadiums;
import site.metacoding.baseball.domain.stadiums.StadiumsDao;
import site.metacoding.baseball.web.dto.request.stadiums.InsertDto;

@RequiredArgsConstructor
@Service
public class StadiumsService {
	
	private final StadiumsDao stadiumsDao;
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 야구장삭제(Integer id) {
		Stadiums stadiumsPS = stadiumsDao.findById(id);
		stadiumsDao.deleteById(id);

	}

	public void 야구장등록(InsertDto insertDto) {	
		Stadiums stadiums = insertDto.toEntity();
		stadiumsDao.insert(insertDto);
	}
	
	public List<Stadiums> 야구장목록보기() {	
		List<Stadiums> stadiumsList = stadiumsDao.findAll();
		return stadiumsList;
	}

}
