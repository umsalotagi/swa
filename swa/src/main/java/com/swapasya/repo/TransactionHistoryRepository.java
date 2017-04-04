package com.swapasya.repo;

import org.springframework.data.repository.CrudRepository;

import com.swapasya.domains.TransactionHistory;

public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, String> 
{

}
