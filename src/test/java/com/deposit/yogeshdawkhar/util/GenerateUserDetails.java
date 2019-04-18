package com.deposit.yogeshdawkhar.util;

import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.provider.Arguments;

import com.deposit.yogeshdawkhar.page.User;

public class GenerateUserDetails {

	public User addUserWithValidData() {
		String email = generateRandomCredentials(15, false);
		String name = generateRandomCredentials(15, true);
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = passwo;
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithOutName() {
		String email = generateRandomCredentials(15, false);
		String name = "";
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = generateRandomCredentials(15, true);
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithOutEmail() {
		String email = "";
		String name = generateRandomCredentials(15, true);
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = passwo;
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithOutPassword() {
		String email = generateRandomCredentials(15, false);
		String name = generateRandomCredentials(15, true);
		String passwo = "";
		String confirmationPasswo = generateRandomCredentials(15, true);
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithOutConfirmPassword() {
		String email = generateRandomCredentials(15, false);
		String name = generateRandomCredentials(15, true);
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = "";
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithMinPassword() {
		String email = generateRandomCredentials(15, false);
		String name = generateRandomCredentials(15, true);
		String passwo = generateRandomCredentials(4, true);
		String confirmationPasswo = passwo;
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithDiffrentConfirmPasswordWithOtherValues() {
		String email = generateRandomCredentials(15, false);
		String name = generateRandomCredentials(15, true);
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = generateRandomCredentials(15, true);
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithDiffrentConfirmPasswordWithoutOtherValues() {
		String email = "";
		String name = "";
		String passwo = generateRandomCredentials(15, true);
		String confirmationPasswo = generateRandomCredentials(15, true);
		return new User(name, email, passwo, confirmationPasswo);
	}

	public User addUserWithOutAnyValue() {
		String email = "";
		String name = "";
		String passwo = "";
		String confirmationPasswo = "";
		return new User(name, email, passwo, confirmationPasswo);
	}

	/**
	 * @Purpose This method will generate a random integer
	 * @param length --> the length of the random emails we want to generate
	 * @return method will return a random email String
	 */
	public static String generateRandomCredentials(int length, boolean str) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-*#$%^&*";
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);

		/**
		 * if str is true, Generate a string without @testData.com., for name and
		 * password
		 */
		if (str) {
			// Log.info("Generating a Random String");
			return temp.substring(0, length);
		}
		/**
		 * if str is false, Generate a string with @testData.com., for email
		 */
		else if (!str) {
			email = temp.substring(0, length) + "@testdata.com";
			return email;
		}
		return null;
	}

	/**
	 * @Purpose This method will generate a random integer
	 * @param length --> the length of the random emails we want to generate
	 * @return method will return a random email String
	 */
	public static String generateRandomEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-*#$%^&*";
		String temp = RandomStringUtils.random(length, allowedChars);
		return temp.substring(0, length) + "@testdata.com";
	}

	static Stream<Arguments> getInvalidEmailId() {
		return Stream.of(
				Arguments.of(generateRandomCredentials(15, true), "plainaddress", generateRandomCredentials(15, true),
						generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "#@%^%#$@#$@#.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "@domain.com", generateRandomCredentials(15, true),
						generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "Yogesh D <email@domain.com>",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email.domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email@domain@domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), ".email@domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email.@domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email..email@domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "あいうえお@domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email@domain.com (Yogesh D)",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email@domain", generateRandomCredentials(15, true),
						generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email@-domain.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "email@domain..com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "Abc.example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "A@b@c@example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "just\"not\"right@example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "this is\"not\\allowed@example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "this\\ still\\\"not\\\\allowed@example.com",
						generateRandomCredentials(15, true), generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), "1", generateRandomCredentials(15, true),
						generateRandomCredentials(15, true)),
				Arguments.of(generateRandomCredentials(15, true), ".@.", generateRandomCredentials(15, true),
						generateRandomCredentials(15, true)));
	}

	static Stream<Arguments> getValidEmailId() {
		String pass;
		return Stream.of(
				Arguments.of(generateRandomCredentials(15, true), "email@domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "firstname.lastname@domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "email@subdomain.domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "firstname+lastname@domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "email@123.123.123.123",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "1234567890@domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "email@domain-one.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "_______@domain.com",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "email@domain.name",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "email@domain.co.jp",
						pass = generateRandomCredentials(15, true), pass),
				Arguments.of(generateRandomCredentials(15, true), "firstname-lastname@domain.com",
						pass = generateRandomCredentials(15, true), pass));
	}
}
