package site.metacoding.baseball.domain.teams;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface TeamsDao {

	public void insert(Teams teams);
	public List<Teams> findAll();
	public Teams findById(Integer id);
	public void update(Teams teams);
	public void deleteById(Integer id);
}
