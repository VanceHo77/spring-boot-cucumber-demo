package com.vance.springbootcucumber.repository;

import com.vance.springbootcucumber.entity.BlackListPan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlackListPanRepository extends CrudRepository<BlackListPan, Integer> {

    Optional<BlackListPan> findByPanInfoId(Integer panInfoId);
}
