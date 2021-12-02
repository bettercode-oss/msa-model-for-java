package kr.bettercode.msamodelforjava.repository;

import kr.bettercode.msamodelforjava.model.Example;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleRepository {

  Example findById(Long id);

  Long save(Example example);

  Long updateByIdSelective(Example example);

  Long deleteById(Example example);
}
