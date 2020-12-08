package test.project.response;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.project.domain.Status;
import test.project.request.GetSpecialOffer;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class GetOfferListResponse {

	private Status message;

	private List<GetSpecialOffer> getSpecialList;

}