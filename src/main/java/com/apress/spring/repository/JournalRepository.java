package com.apress.spring.repository;

import com.apress.spring.domain.Journal;

import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal, String> {
}