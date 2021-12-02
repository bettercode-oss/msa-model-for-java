package kr.bettercode.msamodelforjava.example.repository;

import java.util.List;
import kr.bettercode.msamodelforjava.example.dto.request.ExampleSearchRequest;
import kr.bettercode.msamodelforjava.example.dto.request.PageRequest;
import kr.bettercode.msamodelforjava.example.dto.response.PagingInfoResponse;
import kr.bettercode.msamodelforjava.example.model.Example;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExampleRepository {

  Example findById(Long id);

  void save(Example example);

  void updateByIdSelective(Example example);

  void deleteById(Long id);

  List<Example> list(PageRequest pageRequest);

  PagingInfoResponse getPagingInfo(PageRequest pageRequest);

  List<Example> listSearch(
      @Param("pageRequest") PageRequest pageRequest,
      @Param("searchRequest") ExampleSearchRequest searchRequest
  );

  PagingInfoResponse getPagingInfoSearch(
      @Param("pageRequest") PageRequest pageRequest,
      @Param("searchRequest") ExampleSearchRequest searchRequest);
}
