package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadiums.Stadiums;
import site.metacoding.baseball.domain.stadiums.StadiumsDao;
import site.metacoding.baseball.domain.teams.Teams;
import site.metacoding.baseball.domain.teams.TeamsDao;
import site.metacoding.baseball.web.dto.request.teams.TeamSaveDto;
import site.metacoding.baseball.web.dto.response.teams.TeamListDto;

@RequiredArgsConstructor
@Service
public class TeamsService {

	private final TeamsDao teamsDao;
	private final StadiumsDao stadiumsDao;
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 팀삭제(Integer id) {
		Teams teamsPS = teamsDao.findById(id);
		teamsDao.deleteById(id);

	}

	public void 팀등록(TeamSaveDto teamSaveDto) {
		Teams teams = teamSaveDto.toEntity();
		teamsDao.insert(teamSaveDto);
	}
	
	public List<Teams> 팀목록보기() {	
		List<Teams> teamList = teamsDao.findAll();
		return teamList;
	}


}
