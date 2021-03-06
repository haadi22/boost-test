package test.project.response;

import java.util.Date;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.project.domain.Status;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateSpecialOfferResponse {

	private Status message;
	
	private String voucherCode;

	

}