package org.example.provider

import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactBroker
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.mock.mockito.MockBean


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Provider("provider")
@PactBroker(host = "esineng.pactflow.io", authentication = PactBrokerAuth(token = "my rw token"))
class ProviderApplicationTests {
    @MockBean
    lateinit var orderRepository: OrderRepository

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider::class)
    fun pactVerificationTestTemplate(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @State("state 1")
    fun switchToState1() {
        Mockito.`when`(orderRepository.getOrder(1)).then { Order(id = 1) }
    }

}
