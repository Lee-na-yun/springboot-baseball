package site.metacoding.baseball.web;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.stadiums.Stadiums;
import site.metacoding.baseball.domain.stadiums.StadiumsDao;
import site.metacoding.baseball.domain.teams.Teams;
import site.metacoding.baseball.domain.teams.TeamsDao;
import site.metacoding.baseball.service.StadiumsService;
import site.metacoding.baseball.service.TeamsService;
import site.metacoding.baseball.web.dto.request.teams.TeamSaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class TeamsController {
	
	private final TeamsService teamsService;
	private final TeamsDao teamsDao;
	private final StadiumsService stadiumsService;
	private final StadiumsDao stadiumsDao;
	
	@DeleteMapping("/teams/{id}")
	public @ResponseBody CMRespDto<?> deleteTeam(@PathVariable Integer id){
		teamsService.팀삭제(id);
		return new CMRespDto<>(1, "팀삭제 성공", null);
	}

	@PostMapping("/teamSaveForm")
	public @ResponseBody CMRespDto<?> saveTeam(@RequestBody TeamSaveDto teamSaveDto) {
		teamsService.팀등록(teamSaveDto);
		return new CMRespDto<>(1, "팀등록 성공", null);
	}

	@GetMapping("/teamSaveForm")
	public String teamSaveForm(Model model) {
		List<Stadiums> stadiumsList = stadiumsService.야구장목록보기();
		model.addAttribute("stadiumsList", stadiumsList);
		return "/teams/teamSaveForm";
	}

	@GetMapping("/teamList")
	public String getTeamList(Model model){
		List<Teams> teamList = teamsService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "/teams/teamList";
	}
	
	//@GetMapping("/teams/{id}")
	//public @ResponseBody Teams getTeams(@PathVariable Integer id){
	//	return teamsDao.findById(id);
	//}

	
}
