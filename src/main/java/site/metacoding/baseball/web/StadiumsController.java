package site.metacoding.baseball.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import site.metacoding.baseball.service.StadiumsService;
import site.metacoding.baseball.web.dto.request.stadiums.InsertDto;
import site.metacoding.baseball.web.dto.response.CMRespDto;

@RequiredArgsConstructor
@Controller
public class StadiumsController {

	private final HttpSession session;
	private final StadiumsService stadiumsService;
	private final StadiumsDao stadiumsDao;

	@DeleteMapping("/stadiums/{id}")
	public @ResponseBody CMRespDto<?> deleteStadium(@PathVariable Integer id){
		stadiumsService.야구장삭제(id);
		return new CMRespDto<>(1, "야구장삭제 성공", null);
	}


	@PostMapping("/insertForm")
	public @ResponseBody CMRespDto<?> insertStadium(@RequestBody InsertDto insertDto) {
		stadiumsService.야구장등록(insertDto);
		return new CMRespDto<>(1, "야구장등록 성공", null);
	}

	@GetMapping("/insertForm")
	public String insertForm() {
		return "stadiums/insertForm";
	}

	@GetMapping({ "/", "/stadiums" })
	public String getStadiumsList(Model model){
		List<Stadiums> stadiumList = stadiumsService.야구장목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "stadiums/main";
	}


}
