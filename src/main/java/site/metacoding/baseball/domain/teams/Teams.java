package site.metacoding.baseball.domain.teams;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Teams {

	private Integer id;
	private Integer stadiumId;
	private String teamname;
	private Timestamp createdAt;
}
