package site.metacoding.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.players.PlayersDao;
import site.metacoding.baseball.domain.teams.Teams;
import site.metacoding.baseball.service.PlayersService;
import site.metacoding.baseball.service.TeamsService;
import site.metacoding.baseball.web.dto.request.players.PlayerSaveDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;
import site.metacoding.baseball.web.dto.response.players.PlayerListDto;

@RequiredArgsConstructor
@Controller
public class PlayersController {
	
	private final PlayersService playersService;
	private final PlayersDao playersDao;
	private final TeamsService teamsService;
	
	
	@DeleteMapping("/players/{id}")
	public @ResponseBody CMRespDto<?> deletePlayer(@PathVariable Integer id){
		playersService.선수삭제(id);
		return new CMRespDto<>(1, "선수삭제 성공", null);
	}

	@PostMapping("/playerSaveForm")
	public @ResponseBody CMRespDto<?> savePlayer(@RequestBody PlayerSaveDto playerSaveDto) {
		playersService.선수등록(playerSaveDto);
		return new CMRespDto<>(1, "선수등록 성공", null);
	}

	@GetMapping("/playerSaveForm")
	public String playerSaveForm(Model model) {
		List<Teams> teamList = teamsService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "players/playerSaveForm";
	}

	@GetMapping("/playerList")
	public String getPlayerList(Model model){
		playersService.선수목록보기();
		List<PlayerListDto> playerList = playersDao.findAll();
		model.addAttribute("playerList", playerList);
		return "players/playerList";
	}
	

	//@GetMapping("/teams/{id}")
	//public @ResponseBody Teams getTeams(@PathVariable Integer id){
	//	return teamsDao.findById(id);
	//}

	
}
