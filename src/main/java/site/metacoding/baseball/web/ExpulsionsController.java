package site.metacoding.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.expulsions.ExpulsionsDao;
import site.metacoding.baseball.domain.players.PlayersDao;
import site.metacoding.baseball.domain.teams.Teams;
import site.metacoding.baseball.service.ExpulsionsService;
import site.metacoding.baseball.service.PlayersService;
import site.metacoding.baseball.service.TeamsService;
import site.metacoding.baseball.web.dto.request.expulsions.ExpulsionsDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;
import site.metacoding.baseball.web.dto.response.expulsions.expulsionsListDto;
import site.metacoding.baseball.web.dto.response.players.PlayerListDto;


@RequiredArgsConstructor
@Controller
public class ExpulsionsController {
	
	private final ExpulsionsService expulsionsService;
	private final ExpulsionsDao expulsionsDao;
	private final TeamsService teamsService;
	private final PlayersService playersService;
	private final PlayersDao playersDao;

	@PostMapping("/expulsionsForm")
	public @ResponseBody CMRespDto<?> savePlayer(@RequestBody ExpulsionsDto expulsionsDto) {
		expulsionsService.퇴출선수등록(expulsionsDto);
		return new CMRespDto<>(1, "퇴출선수 등록 성공", null);
	}
	
	@GetMapping("/expulsionsForm")
	public String expulsionSaveForm(Model model) {
		List<Teams> teamList = teamsService.팀목록보기();
		List<PlayerListDto> playerList = playersDao.findAll();
		playersService.선수목록보기();
		model.addAttribute("teamList", teamList);
		model.addAttribute("playerList", playerList);
		return "expulsions/expulsionsForm";
	}
	
	//@GetMapping("/expulsionsList")
	//public String getPlayerList(Model model){
	//	playersService.선수목록보기();
	//	List<PlayerListDto> playerList = playersDao.findAll();
	//	model.addAttribute("playerList", playerList);
	//	return "expulsions/expulsionsList";
	//}
	
	@GetMapping("/expulsionsList")
	public String getExpulsionList(Model model){
		expulsionsService.퇴출선수목록보기();
		List<expulsionsListDto> expulsionsList = expulsionsDao.findAll();
		List<Teams> teamList = teamsService.팀목록보기();
		playersService.선수목록보기();
		List<PlayerListDto> playerList = playersDao.findAll();
		model.addAttribute("expulsionsList", expulsionsList);
		model.addAttribute("playerList", playerList);
		model.addAttribute("teamList", teamList);
		return "expulsions/expulsionsList";
	}
}
