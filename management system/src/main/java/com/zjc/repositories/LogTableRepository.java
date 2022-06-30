package com.zjc.repositories;

import com.zjc.pojo.Logtable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTableRepository extends PagingAndSortingRepository<Logtable,Integer> {
}
