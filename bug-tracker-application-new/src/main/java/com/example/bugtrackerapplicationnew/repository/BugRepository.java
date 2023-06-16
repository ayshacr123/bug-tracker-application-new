package com.example.bugtrackerapplicationnew.repository;


import com.example.bugtrackerapplicationnew.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug,Long> {

        }
