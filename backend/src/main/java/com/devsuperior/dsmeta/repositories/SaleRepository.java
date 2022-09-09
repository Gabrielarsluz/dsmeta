package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Long> {

	/*função que faz pesquisa no BD recebendo as datas como argumento
	 *""SELECT obj FROM..." comando na linguagem SPQL, adaptação para ser usada aqui na JPA 
	 *"selecione objeto da tabela Sale onde a data do obj estiver entre os parâmetros da função findSales (:min e :max
	 *ordenando os objetos pelo valor da venda em ordem decrescente) obs.: virá uma página com os 20 prim valores"*/
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
}
