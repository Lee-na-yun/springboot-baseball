package site.metacoding.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.expulsions.Expulsions;
import site.metacoding.baseball.domain.expulsions.ExpulsionsDao;
import site.metacoding.baseball.service.ExpulsionsService;
import site.metacoding.baseball.web.dto.request.expulsions.ExpulsionsDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;


@RequiredArgsConstructor
@Controller
public class ExpulsionsController {
	
	private final ExpulsionsService expulsionsService;
	private final ExpulsionsDao expulsionsDao;

	@PostMapping("/expulsionsForm")
	public @ResponseBody CMRespDto<?> savePlayer(@RequestBody ExpulsionsDto expulsionsDto) {
		expulsionsService.퇴출선수등록(null);
		return new CMRespDto<>(1, "퇴출선수 등록 성공", null);
	}
	

	@GetMapping("/expulsionsList")
	public String getExpulsionList(Model model){
		expulsionsService.퇴출선수목록보기();
		List<Expulsions> expulsionsList = expulsionsDao.findAll();
		model.addAttribute("expulsionsList", expulsionsList);
		return "expulsions/expulsionsList";
	}
}
