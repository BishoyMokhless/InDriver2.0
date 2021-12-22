package com.example.advSoft.DB;

import com.example.advSoft.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("repo")
public interface DriverDB extends JpaRepository<Driver,Integer>  {
}
