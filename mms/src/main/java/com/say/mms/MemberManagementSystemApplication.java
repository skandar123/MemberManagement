package com.say.mms;

import com.say.mms.entity.Member;
import com.say.mms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagementSystemApplication.class, args);
	}

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
//		Member member1=new Member("Anu","Jha","anu.jha@gmail.com");
//		memberRepository.save(member1);
//
//		Member member2=new Member("Rish","Dev","rdev225678@gmail.com");
//		memberRepository.save(member2);
//
//		Member member3=new Member("Jacob","Black","jackblack675@gmail.com");
//		memberRepository.save(member3);
	}
}
