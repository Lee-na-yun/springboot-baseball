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
	private String name;
	private Timestamp createDate;

	public Teams(Integer stadiumId, String name) {
		this.stadiumId = stadiumId;
		this.name = name;
	}
}
