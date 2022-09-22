package site.metacoding.baseball.domain.stadiums;

import java.util.List;

import site.metacoding.baseball.web.dto.request.stadiums.InsertDto;



public interface StadiumsDao {
	public void insert(InsertDto insertDto);
	public List<Stadiums> findAll();
	public void deleteById(Integer id);
	public Stadiums findById(Integer id, String name);
	public void update(Stadiums stadiums);
	
	
}
