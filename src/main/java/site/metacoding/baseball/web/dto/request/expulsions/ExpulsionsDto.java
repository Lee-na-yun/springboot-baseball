package site.metacoding.baseball.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.baseball.domain.expulsions.Expulsions;

@Setter
@Getter
public class ExpulsionsDto {

	private String playerId;
	private String name;
	private String reason;
	
	public Expulsions toEntity() {
		Expulsions expulsions = new Expulsions(this.playerId, this.name, this.reason);
		return expulsions;
	}
	

}
