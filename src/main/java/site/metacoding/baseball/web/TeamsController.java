package site.metacoding.baseball.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.teams.Teams;
import site.metacoding.baseball.domain.teams.TeamsDao;

@RequiredArgsConstructor
@Controller
public class TeamsController {
	
	private final TeamsDao teamsDao;
	
	@GetMapping("/teams/{id}")
	public @ResponseBody Teams getTeams(@PathVariable Integer id){
		return teamsDao.findById(id);
	}

	
}
