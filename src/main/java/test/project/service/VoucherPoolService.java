package test.project.service;

import test.project.request.CreateSpecialOfferRequest;
import test.project.request.CreateVoucherCodeRequest;
import test.project.request.GetOfferListRequest;
import test.project.request.SpecialOfferRequest;
import test.project.request.UseVoucherRequest;
import test.project.response.CreateSpecialOfferResponse;
import test.project.response.CreateVoucherCodeResponse;
import test.project.response.GetOfferListResponse;
import test.project.response.UseVoucherResponse;

public interface VoucherPoolService {

//	public CreateVoucherCodeResponse createVoucherCode(CreateVoucherCodeRequest req);
	
	public CreateSpecialOfferResponse createSpecialOffer(CreateSpecialOfferRequest req);
	
	public UseVoucherResponse useVoucher(UseVoucherRequest req);

	public GetOfferListResponse getOfferList(GetOfferListRequest req);
}