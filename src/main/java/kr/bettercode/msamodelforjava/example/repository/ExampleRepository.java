package kr.bettercode.msamodelforjava.example.repository;

import java.util.List;
import kr.bettercode.msamodelforjava.example.dto.request.PageRequest;
import kr.bettercode.msamodelforjava.example.dto.response.PagingInfoResponse;
import kr.bettercode.msamodelforjava.example.model.Example;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleRepository {

  Example findById(Long id);

  Long save(Example example);

  Long updateByIdSelective(Example example);

  void deleteById(Long id);

  List<Example> list(PageRequest pageRequest);

  PagingInfoResponse getPagingInfo(PageRequest pageRequest);
}
