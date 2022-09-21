package com.example.demo.tmpuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TURepository extends JpaRepository<TmpUser, String> {
}
