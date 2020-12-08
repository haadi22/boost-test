package test.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.project.entity.VoucherCode;

public interface VoucherCodeRepo extends JpaRepository<VoucherCode, Long> {
	
	
	VoucherCode findByGeneratedCode(String generatedCode);

}