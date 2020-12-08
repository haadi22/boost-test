package test.project.request;

import java.util.Date;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class GetSpecialOffer {

	
	private String specialOffer;

	private String voucherCode;
	
		
}