package site.metacoding.baseball.domain.expulsions;

import java.util.List;


public interface ExpulsionsDao {

	public void insert(Expulsions Expulsions);
	List<Expulsions> findAll();
}
