package site.metacoding.baseball.domain.expulsions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Expulsions {
	
	private Integer id;
	private Integer no;
	private String playerId;
	private String teamId;
	private String teamname;
	private String name;
	private String position;
	private String reason;
	private String createDate;
	
	public Expulsions(String playerId, String name, String reason) {
		this.playerId = playerId;
		this.name = name;
		this.reason = reason;
	}
	

}
