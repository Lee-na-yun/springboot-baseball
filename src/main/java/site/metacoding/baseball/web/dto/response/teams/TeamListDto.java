package site.metacoding.baseball.web.dto.response.teams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamListDto {
	private Integer id;
	private String name;
	private String stadiumname;
	private String createDate;

}