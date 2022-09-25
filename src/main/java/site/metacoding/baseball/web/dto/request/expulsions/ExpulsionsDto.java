package site.metacoding.baseball.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExpulsionsDto {

	private String teamname;
	private String name;
	private String reason;
	private String createdDate;
	
	

}
