package org.spring.protobuf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProtobufApplicationTests {

	@Test
	void contextLoads() {
		String email="jieun@sookmyung.ac.kr";
		int id=22;
		String name="jieun lee";

		PersonProto.Person person=
				PersonProto.Person.newBuilder()
						.setId(id)
						.setName(name)
						.setEmail(email)
						.build();

		System.out.println("-------");
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getEmail());
		System.out.println("-------");

	}


}
