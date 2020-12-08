package test.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.project.entity.Recipient;

public interface RecipientRepo extends JpaRepository<Recipient, Long> {
	
	
	List<Recipient> findByEmail(String email);

}