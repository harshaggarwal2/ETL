package org.harsh.learning.repository;

import org.harsh.learning.entity.ModifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyRepository extends JpaRepository<ModifyEntity, Integer> {
}