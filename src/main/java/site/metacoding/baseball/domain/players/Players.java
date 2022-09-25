package site.metacoding.baseball.domain.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Players {

	private Integer id;
	private Integer teamId;
	private String name;
	private String position;
	private Integer playerNum;
	private Timestamp createDate;
	
	public Players(Integer teamId, String name, String position, Integer playerNum) {
		this.teamId = teamId;
		this.name = name;
		this.position = position;
		this.playerNum = playerNum;
	}
	

}
