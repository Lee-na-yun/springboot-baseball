package site.metacoding.baseball.domain.players;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Players {

	private Integer id;
	private Integer teamId;
	private String username;
	private String position;
	private Integer playerNum;
}
