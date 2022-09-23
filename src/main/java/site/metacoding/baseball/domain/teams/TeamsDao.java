package site.metacoding.baseball.domain.teams;

import java.util.List;

import site.metacoding.baseball.web.dto.request.teams.TeamSaveDto;
import site.metacoding.baseball.web.dto.response.teams.TeamListDto;


public interface TeamsDao {

	public void insert(TeamSaveDto teamSaveDto);
	public List<Teams> findAll();
	public Teams findById(Integer id);
	public void update(Teams teams);
	public void deleteById(Integer id);
}
