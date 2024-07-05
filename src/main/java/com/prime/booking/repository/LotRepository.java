package com.prime.booking.repository;


import com.prime.booking.filter.LotEntityFilter;
import com.prime.booking.model.LotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface LotRepository extends JpaRepository<LotEntity, Long>, JpaSpecificationExecutor<LotEntity> {
    default Page<LotEntity> findAll(LotEntityFilter lotEntityFilter, Pageable pageable) {
        return lotEntityFilter == null ? findAll(pageable) : findAll(lotEntityFilter.toSpecification(), pageable);
    }
}
