package site.metacoding.baseball.domain.stadiums;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class Stadiums {

	private Integer id;
	private String name;
	private Timestamp createdAt;
	
	public Stadiums(String name) {
		this.name = name;

	}
}
