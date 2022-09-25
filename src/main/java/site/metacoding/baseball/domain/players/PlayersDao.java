package site.metacoding.baseball.domain.players;

import java.util.List;

import site.metacoding.baseball.web.dto.request.players.PlayerSaveDto;
import site.metacoding.baseball.web.dto.response.players.PlayerListDto;
import site.metacoding.baseball.web.dto.response.players.PlayerPositionGroup;

public interface PlayersDao {

	public void insert(PlayerSaveDto playerSaveDto);
	public List<PlayerListDto> findAll();
	public Players findById(Integer id);
	public void update(Players Players);
	public void deleteById(Integer id);
	public List<PlayerPositionGroup> findPlayerforPosition();
}
