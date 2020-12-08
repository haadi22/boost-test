package test.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.project.entity.SpecialOffer;
import test.project.entity.VoucherCode;

public interface SpecialOfferRepo extends JpaRepository<SpecialOffer, Long> {

	List<SpecialOffer> findByName(String name);
	
	
	SpecialOffer findByVoucherCodeId(VoucherCode voucherCodeId);

}