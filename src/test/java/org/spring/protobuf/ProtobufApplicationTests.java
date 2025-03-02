package org.spring.protobuf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class ProtobufApplicationTests {

	@Test
	void contextLoads() throws IOException {
		String email="jieun@sookmyung.ac.kr";
		int id=22;
		String name="jieun lee";

		//person 객체 생성
		PersonProto.Person person=
				PersonProto.Person.newBuilder()
						.setId(id)
						.setName(name)
						.setEmail(email)
						.build();

		//AddressBook 객체 생성
		PersonProto.AddressBook addressBook
				= PersonProto.AddressBook.newBuilder()
						.addPeople(person)
						.build();

		String filePath="C:/Users/marie/Documents/addressBook.bin";

		//직렬화
		FileOutputStream fos = new FileOutputStream(filePath);
		addressBook.writeTo(fos);
		fos.close();

		//역직렬화
		FileInputStream fis = new FileInputStream(filePath);
		PersonProto.AddressBook deserialized = PersonProto.AddressBook.parseFrom(fis);
		fis.close();

		for (PersonProto.Person p : deserialized.getPeopleList()) {
			System.out.println("Name: "+ p.getName());
			System.out.println("Id: " + p.getId());
			System.out.println("Email: " + p.getEmail());
		}

	}


}
