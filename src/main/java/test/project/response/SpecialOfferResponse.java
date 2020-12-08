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
public class SpecialOfferResponse {

	private String name;

	private Integer fixedPercentageDiscount;

}