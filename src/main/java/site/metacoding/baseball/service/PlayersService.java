package site.metacoding.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.baseball.domain.players.Players;
import site.metacoding.baseball.domain.players.PlayersDao;
import site.metacoding.baseball.web.dto.request.players.PlayerSaveDto;
import site.metacoding.baseball.web.dto.response.players.PlayerListDto;
import site.metacoding.baseball.web.dto.response.players.PlayerPositionGroup;

@RequiredArgsConstructor
@Service
public class PlayersService {

	private final PlayersDao playersDao;
	
	public List<PlayerPositionGroup> 포지션별선수목록보기(){
		List<PlayerPositionGroup> playerList2 = playersDao.findPlayerforPosition();
		return playerList2;
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 선수삭제(Integer id) {
		Players playersPS = playersDao.findById(id);
		playersDao.deleteById(id);

	}
	
	public void 선수등록(PlayerSaveDto playerSaveDto) {	
		Players players = playerSaveDto.toEntity();
		playersDao.insert(playerSaveDto);
	}
	
	public List<PlayerListDto> 선수목록보기() {	
		List<PlayerListDto> playerList = playersDao.findAll();
		return playerList;
	}
}
