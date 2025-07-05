package com.mms;

import com.mms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);
	}

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
