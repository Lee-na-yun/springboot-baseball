package site.metacoding.baseball.domain.expulsions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Expulsions {

	private Integer id;
	private String reason;
	private String playerId;
	private String teamname;
	private String createdDate;
	

}
