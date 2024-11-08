package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.authorities.UserRole;
import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.config.AppPasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseLektion6SpringSecurityIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseLektion6SpringSecurityIntroApplication.class, args);

		System.out.println("---ADMIN---");
		System.out.println(
				UserRole.ADMIN.getListOfPermissions()
		);

		System.out.println("---USER---");
		System.out.println(
				UserRole.USER.getListOfPermissions()
		);

		System.out.println("---GetAuthorities---");
		System.out.println(UserRole.ADMIN.name()); // Should not return ROLE_ + name
		System.out.println(
				UserRole.ADMIN.getAuthorities()
		);

	}

}
