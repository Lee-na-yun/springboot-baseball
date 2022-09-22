package site.metacoding.baseball.domain.players;

import java.util.List;

import site.metacoding.baseball.domain.players.Players;

public interface PlayersDao {

	public void insert(Players players);
	public List<Players> findAll();
	public Players findById(Integer id);
	public void update(Players Players);
	public void deleteById(Integer id);
}
