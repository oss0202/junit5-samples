/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTests {

	@BeforeAll
	static void beforeAll(){
		System.out.println("call BeforeALl");
	}
	@BeforeEach
	void beforeEach(){
		System.out.println("	call BeforeEach");
	}

	@Test//Test Method
	@Order(1)
	@DisplayName("1 + 1 = 2")//IDE에 표시될 이름
	void addsTwoNumbers() {
		System.out.println("		call Test addsTwoNumbers");
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test//Test Method
	@Order(2)
	@DisplayName("10 + 10 = 22")//IDE에 표시될 이름
	void addsTwoNumbers2() {
		System.out.println("		call Test addsTwoNumbers222222");
		Calculator calculator = new Calculator();
		assertEquals(20, calculator.add(10, 10), "10 + 10 should equal 20");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")//매개변수화된 테스트
	@Order(3)
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})//인수 목록을 쉼표로 구분된 값(즉, String 리터럴-변수의 값이 변하지 않는 데이터, 메모리 위치 안의 값)
	void add(int first, int second, int expectedResult) {
		System.out.println("			call add method");
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@AfterEach
	void afterEach(){
		System.out.println("	call AfterEach");
	}
	@AfterAll
	static void afterAll(){
		System.out.println("call AfterAll");
	}
}
