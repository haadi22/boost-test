package test.project.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateSpecialOfferRequest {

	private String name;
	
	private Integer fixedPercentageDiscount;
	
	private String recipient;
	
	private String email;
	
	private Integer validPeriod;
}