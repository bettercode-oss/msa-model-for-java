package kr.bettercode.msamodelforjava.example.repository;

import kr.bettercode.msamodelforjava.example.model.Example;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleRepository {

  Example findById(Long id);

  Long save(Example example);

  Long updateByIdSelective(Example example);

  void deleteById(Long id);
}
