package kr.bettercode.msamodelforjava.repository;

import java.util.List;
import kr.bettercode.msamodelforjava.dto.ChargePointDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChargePointRepository {

  List<ChargePointDto> selectAll();
}
