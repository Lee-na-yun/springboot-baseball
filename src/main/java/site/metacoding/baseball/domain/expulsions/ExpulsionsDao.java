package site.metacoding.baseball.domain.expulsions;

import java.util.List;

import site.metacoding.baseball.web.dto.request.expulsions.ExpulsionsDto;
import site.metacoding.baseball.web.dto.response.expulsions.expulsionsListDto;


public interface ExpulsionsDao {

	public void insert(ExpulsionsDto expulsionsDto);
	List<expulsionsListDto> findAll();
}
