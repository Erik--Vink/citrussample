package com.infosupport.country;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.dsl.junit.JUnit4CitrusTest;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.ws.client.WebServiceClient;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.consol.citrus.dsl.endpoint.CitrusEndpoints.soap;

@SpringBootTest
public class CountriesServiceIT extends JUnit4CitrusTest {
//
//    @Autowired
    private WebServiceClient countriesClient = CitrusEndpoints.soap()
                .client()
                .defaultUri("http://localhost:8080/ws")
                .build();

    @Test
    @CitrusTest
    public void myTest(@CitrusResource TestRunner runner) {

        runner.soap(action -> action.client(countriesClient)
                .send()
                .soapAction("getCountryRequest")
                .payload(new ClassPathResource("templates/getCountryRequestSpain.xml")));
    }
}
