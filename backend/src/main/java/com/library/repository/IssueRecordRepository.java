package com.library.repository;
import com.library.entity.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IssueRecordRepository extends JpaRepository<IssueRecord,Long>{}