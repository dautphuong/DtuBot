package com.dtubot.repository;

import com.dtubot.entity.DAO.Intents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntentsRepository extends JpaRepository<Intents, String> {
}
