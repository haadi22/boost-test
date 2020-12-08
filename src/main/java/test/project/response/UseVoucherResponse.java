package test.project.response;



import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.project.domain.Status;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UseVoucherResponse {

	private Status message;
	
	private Integer fixPercentageDiscount;
	
	private String usageDate;

	

}