package site.metacoding.baseball.web.dto.request.stadiums;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.stadiums.Stadiums;


@Setter
@Getter
public class InsertDto {

	private String name;
	
	public Stadiums toEntity() {
		Stadiums stadiums = new Stadiums(this.name);
		return stadiums;
	}
	
}
