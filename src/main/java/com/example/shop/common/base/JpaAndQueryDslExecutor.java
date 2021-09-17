package com.example.shop.common.base;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaAndQueryDslExecutor<T, D> extends BaseJpaRepository<T, D>, QuerydslPredicateExecutor<T> {
}
