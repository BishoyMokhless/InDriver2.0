package com.example.advSoft;

import com.example.advSoft.Discount.BirthdayDiscount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import com.example.advSoft.Discount.Discount;

import java.sql.SQLException;

@SpringBootApplication
@RestController
public class AdvancedSoftwareProjectApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SpringApplication.run(AdvancedSoftwareProjectApplication.class, args);
	}
}
