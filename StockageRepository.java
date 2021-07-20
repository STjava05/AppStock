package it.esedra.appstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.esedra.appstock.entity.Stockage;

public interface StockageRepository extends JpaRepository<Stockage,Long> {
	
	public List<Stockage> findAll();
	public Stockage findById(int id);
	public Stockage save(Stockage stockage);

}
