package test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import test.project.request.CreateSpecialOfferRequest;
import test.project.request.CreateVoucherCodeRequest;
import test.project.request.GetOfferListRequest;
import test.project.request.SpecialOfferRequest;
import test.project.request.UseVoucherRequest;
import test.project.response.CreateSpecialOfferResponse;
import test.project.response.CreateVoucherCodeResponse;
import test.project.response.GetOfferListResponse;
import test.project.response.UseVoucherResponse;
import test.project.service.VoucherPoolService;

@Log4j2
@RestController
@RequestMapping("/api")
public class VoucherPoolController {

	@Autowired
	VoucherPoolService voucherpoolservice;

//	@RequestMapping(value = "/createvouchercode", method = RequestMethod.POST)
//	public ResponseEntity<CreateVoucherCodeResponse> createVoucherCode(@RequestBody CreateVoucherCodeRequest req)
//			throws Exception {
//
//		CreateVoucherCodeResponse ret = new CreateVoucherCodeResponse();
//
//		log.debug("CreateVoucherCodeRequest:" + req);
//		ret = voucherpoolservice.createVoucherCode(req);
//		return new ResponseEntity<CreateVoucherCodeResponse>(ret, HttpStatus.OK);
//	}
	
	
	@RequestMapping(value = "/createspecialoffer", method = RequestMethod.POST)
	public ResponseEntity<CreateSpecialOfferResponse> createSpecialOffer(@RequestBody CreateSpecialOfferRequest req)
			throws Exception {

		CreateSpecialOfferResponse ret = new CreateSpecialOfferResponse();

		log.debug("CreateVoucherCodeRequest:" + req);
		ret = voucherpoolservice.createSpecialOffer(req);
		
		
		return new ResponseEntity<CreateSpecialOfferResponse>(ret, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/uservouchercode", method = RequestMethod.POST)
	public ResponseEntity<UseVoucherResponse> useVoucherCode(@RequestBody UseVoucherRequest req)
			throws Exception {

		UseVoucherResponse ret = new UseVoucherResponse();

		log.debug("CreateVoucherCodeRequest:" + req);
		ret = voucherpoolservice.useVoucher(req);
		
		
		return new ResponseEntity<UseVoucherResponse>(ret, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getofferlist", method = RequestMethod.POST)
	public ResponseEntity<GetOfferListResponse> getOfferList(@RequestBody GetOfferListRequest req)
			throws Exception {

		GetOfferListResponse ret = new GetOfferListResponse();

		log.debug("GetOfferListRequest:" + req);
		ret = voucherpoolservice.getOfferList(req);
		
		
		return new ResponseEntity<GetOfferListResponse>(ret, HttpStatus.OK);
	}

}