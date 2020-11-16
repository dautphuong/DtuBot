package com.dtubot.repository;

import com.dtubot.entity.DAO.Intents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntentsRepository extends JpaRepository<Intents,String> {
}
