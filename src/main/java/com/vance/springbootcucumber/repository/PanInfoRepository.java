package com.vance.springbootcucumber.repository;

import com.vance.springbootcucumber.entity.PanInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PanInfoRepository extends CrudRepository<PanInfo, Integer> {

    Optional<PanInfo> findByCardNumber(String cardNumber);
}
