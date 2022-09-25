package site.metacoding.baseball.web.dto.response.expulsions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class expulsionsListDto {

	private Integer no;
	private String teamname;
	private String name;
	private String position;
	private String reason;
	private String createDate;
}
