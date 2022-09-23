package site.metacoding.baseball.web.dto.request.teams;


import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.teams.Teams;


@Setter
@Getter
public class TeamSaveDto {

	private Integer stadiumId;
	private String name;

	public Teams toEntity() {
		Teams teams = new Teams(this.stadiumId, this.name);
		return teams;
	}




}