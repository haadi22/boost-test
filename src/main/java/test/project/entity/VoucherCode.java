
package test.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VOUCHER_CODE")
public class VoucherCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 50,columnDefinition = "serial")
	private Long id;

	@Column(name = "generated_code", length = 100)
	private String generatedCode;
	
	@Column(name = "expiration_date", length = 50)
	private Date expirationDate;
	
	@Column(name = "voucher_used", length = 10)
	private String voucherUsed;
	
	@Column(name = "usage_date", length = 50,nullable = true)
	private Date usageDate;
}