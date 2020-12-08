package test.project.response;
import java.util.Date;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class VoucherCodeResponse {

	private String generatedCode;

	private String voucherCode;

	private Date expirationDate;

	private String voucherUsed;

	private Date usageDate;

}