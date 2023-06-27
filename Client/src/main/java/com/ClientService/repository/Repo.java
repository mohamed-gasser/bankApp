package com.ClientService.repository;
import com.ClientService.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Certificate, Long> {

    @Query("select certi from Certificate certi where certi.name=:nameBind ")
    public Certificate findByQuery(@Param("nameBind") String name);
    @Query("select certi.id from Certificate certi where certi.name=:Name and certi.years=:Years")
    public Long getID(@Param("Name") String name,@Param("Years") Long years);


}
