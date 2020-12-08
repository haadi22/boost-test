package test.project.service.impl;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
//import org.joda.time.LocalDate;
import java.time.LocalDate;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.project.domain.Status;
import test.project.entity.Recipient;
import test.project.entity.SpecialOffer;
import test.project.entity.VoucherCode;
import test.project.repository.RecipientRepo;
import test.project.repository.SpecialOfferRepo;
import test.project.repository.VoucherCodeRepo;
import test.project.request.CreateSpecialOfferRequest;
import test.project.request.CreateVoucherCodeRequest;
import test.project.request.GetOfferListRequest;
import test.project.request.GetSpecialOffer;
import test.project.request.SpecialOfferRequest;
import test.project.request.UseVoucherRequest;
import test.project.response.CreateSpecialOfferResponse;
import test.project.response.CreateVoucherCodeResponse;
import test.project.response.GetOfferListResponse;
import test.project.response.UseVoucherResponse;
import test.project.service.VoucherPoolService;
import test.project.util.ServerUtil;

@Service
public class VoucherPoolServiceImpl implements VoucherPoolService {

	@Autowired
	ServerUtil util;

	@Autowired
	VoucherCodeRepo voucherrepo;

	@Autowired
	SpecialOfferRepo specialofferrepo;

	@Autowired
	RecipientRepo recipientrepo;

	@Override
	public CreateSpecialOfferResponse createSpecialOffer(CreateSpecialOfferRequest req) {
		CreateSpecialOfferResponse res = new CreateSpecialOfferResponse();

		SpecialOffer special = new SpecialOffer();
		VoucherCode voucher = new VoucherCode();
		Recipient recipient = new Recipient();
		Status message = new Status();

		LocalDate futureDate = LocalDate.now().plusDays(req.getValidPeriod());
		LocalDate today = LocalDate.now();
		System.out.println("getValidPeriod() :" + req.getValidPeriod());
		System.out.println("today :" + today);
		System.out.println("futureDate :" + futureDate);
		Date date = Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		try {

			String generateCode = util.rabdomizePassword();
			voucher.setGeneratedCode(generateCode);
			voucher.setExpirationDate(date);
			voucher.setVoucherUsed("N");
			special.setName(req.getName());
			special.setFixPercentageDiscount(req.getFixedPercentageDiscount());
			special.setVoucherCodeId(voucher);

			recipient.setName(req.getRecipient());
			recipient.setEmail(req.getEmail());
			recipient.setVoucherCodeId(voucher);

			specialofferrepo.saveAndFlush(special);
			recipientrepo.saveAndFlush(recipient);

			List<SpecialOffer> specialName = specialofferrepo.findByName(req.getName());

			if (!specialName.isEmpty()) {

				message.setMessage("special offer succesfully created ");
				message.setCode(1);
				res.setMessage(message);
				res.setVoucherCode(generateCode);

			} else {
				message.setMessage("special offer create error ");
				message.setCode(0);
				res.setMessage(message);
				res.setVoucherCode("");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public UseVoucherResponse useVoucher(UseVoucherRequest req) {
		UseVoucherResponse res = new UseVoucherResponse();

		Status message = new Status();
		Date date = new Date();
		SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {

			List<Recipient> getRecipient = recipientrepo.findByEmail(req.getEmail());

			if (!getRecipient.isEmpty()) {

				VoucherCode getVoucher = voucherrepo.findByGeneratedCode(req.getVoucherCode());

				System.out.println("getVoucher " + getVoucher);

				if (getVoucher != null) {
					SpecialOffer special = specialofferrepo.findByVoucherCodeId(getVoucher);

					DateTime expiredDate = new DateTime(getVoucher.getExpirationDate());
					DateTime cDate = new DateTime(date);

					int dayelapse = getElapseDay(expiredDate, cDate);

					System.out.println("expiredDate :" + getVoucher.getExpirationDate());
					System.out.println("currentDate :" + cDate);
					System.out.println("dayelapse :" + dayelapse);

					if (dayelapse < 0) {

						System.out.println("voucher code valid :");
						
						 if (!getVoucher.getVoucherUsed().equals("Y") && !getVoucher.getVoucherUsed().equals("X")) {
						 getVoucher.setVoucherUsed("Y");
						 getVoucher.setUsageDate(date);
						
						 voucherrepo.saveAndFlush(getVoucher);
						
						 message.setMessage("voucher code for entered email is redeemed");
						 message.setCode(2);
						 res.setMessage(message);
						 res.setMessage(message);
						 res.setFixPercentageDiscount(special.getFixPercentageDiscount());
						
						 String currentDate = dmyFormat.format(getVoucher.getUsageDate());
						 res.setUsageDate(currentDate);
						
						 } else {
						
						 message.setMessage("voucher code for entered email is used / expired");
						 message.setCode(3);
						 res.setMessage(message);
						 res.setFixPercentageDiscount(special.getFixPercentageDiscount());
						
						 String currentDate = dmyFormat.format(getVoucher.getUsageDate());
						 res.setUsageDate(currentDate);
						 }

						
					} else {
						System.out.println("voucher code invalid :");
						 getVoucher.setVoucherUsed("X");
						 
						 voucherrepo.saveAndFlush(getVoucher);
						 message.setMessage("voucher code for entered email is expired");
						 message.setCode(0);
						 res.setMessage(message);
						 res.setFixPercentageDiscount(0);
						 res.setUsageDate("");
					}

					
				} else {

					message.setMessage("voucher code for entered email is not exist");
					message.setCode(0);
					res.setMessage(message);
					res.setFixPercentageDiscount(0);
					res.setUsageDate("");
				}

			} else {

				message.setMessage("email is not exist");
				message.setCode(0);
				res.setMessage(message);
				res.setFixPercentageDiscount(0);
				res.setUsageDate("");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return res;
	}

	@Override
	public GetOfferListResponse getOfferList(GetOfferListRequest req) {
		GetOfferListResponse res = new GetOfferListResponse();

		GetSpecialOffer getSpecial = new GetSpecialOffer();
		List<GetSpecialOffer> getSpecialList = new ArrayList<>();
		Status message = new Status();

		try {

			List<Recipient> getRecipient = recipientrepo.findByEmail(req.getEmail());

			if (!getRecipient.isEmpty()) {

				for (Recipient obj : getRecipient) {

					if (!obj.getVoucherCodeId().getVoucherUsed().equals("X")) {

						SpecialOffer special = specialofferrepo.findByVoucherCodeId(obj.getVoucherCodeId());

						getSpecial.setSpecialOffer(special.getName());
						getSpecial.setVoucherCode(obj.getVoucherCodeId().getGeneratedCode());

						getSpecialList.add(getSpecial);
						getSpecial = new GetSpecialOffer();
					}

				}

				System.out.println("getSpecialList : " + getSpecialList);
				res.setGetSpecialList(getSpecialList);
				message.setMessage("get special offer success");
				message.setCode(4);
				res.setMessage(message);
			} else {
				res.setGetSpecialList(getSpecialList);
				message.setMessage("get special offer error");
				message.setCode(0);
				res.setMessage(message);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return res;
	}

	public Integer getElapseDay(DateTime min, DateTime max) {

		int dayelapse = Days.daysBetween(min, max).getDays();
		return dayelapse;
	}

}