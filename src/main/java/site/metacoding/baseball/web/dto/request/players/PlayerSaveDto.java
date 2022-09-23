package site.metacoding.baseball.web.dto.request.players;


import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.players.Players;


@Setter
@Getter
public class PlayerSaveDto {

	private Integer teamId;
	private String name;
	private String position;
	private Integer playerNum;


	public Players toEntity() {
		Players players = new Players(this.teamId, this.name, this.position, this.playerNum);
		return players;
	}




}