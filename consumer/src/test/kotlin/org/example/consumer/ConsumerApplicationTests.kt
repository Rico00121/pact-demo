package org.example.consumer

import au.com.dius.pact.consumer.MockServer
import au.com.dius.pact.consumer.dsl.PactDslWithProvider
import au.com.dius.pact.consumer.junit5.PactConsumerTest
import au.com.dius.pact.consumer.junit5.PactTestFor
import au.com.dius.pact.core.model.PactSpecVersion
import au.com.dius.pact.core.model.RequestResponsePact
import au.com.dius.pact.core.model.annotations.Pact
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.web.client.RestTemplate


@PactConsumerTest
@PactTestFor(providerName = "provider", pactVersion = PactSpecVersion.V3)
class ConsumerApplicationTests {
	private val mapper = ObjectMapper()
	private val restTemplate = RestTemplate()
	private val headers = mapOf("Content-Type" to "application/json")

	@Pact(provider = "provider", consumer = "consumer")
	fun pact1(builder: PactDslWithProvider): RequestResponsePact {
		return builder
			.given("state 1")
			.uponReceiving("test interaction")
			.path("/order")
			.method("GET")
			.willRespondWith()
			.status(200)
			.headers(headers)
			.body(mapper.writeValueAsString(Order(id = 1)))
			.toPact()
	}

	@Test
	@PactTestFor(pactMethod = "pact1")
	fun testPact1(mockServer: MockServer) {
		val responseEntity = restTemplate.getForEntity(mockServer.getUrl() + "/order", Order::class.java)

		Assertions.assertEquals(HttpStatus.OK, responseEntity.statusCode )
		Assertions.assertEquals(1, responseEntity.body?.id )
	}
}
