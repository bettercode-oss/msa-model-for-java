package kr.bettercode.msamodelforjava.repository;

import kr.bettercode.msamodelforjava.model.ChargePoint;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChargePointRepository {

  ChargePoint selectChargePointById(Long id);
}
