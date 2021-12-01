package kr.bettercode.msamodelforjava.repository;

import kr.bettercode.msamodelforjava.model.Example;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleRepository {

  int save(Example example);

  int updateByPrimaryKeySelective(Example example);

  int updateByPrimaryKey(Example example);
}
