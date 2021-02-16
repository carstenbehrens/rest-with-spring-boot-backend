package com.carstenberhens.rest;

import com.carstenberhens.rest.controllers.ProductController;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldGetProductById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(ProductController.URI + "1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"title\":\"Konsole\",\"name\":\"Playstation 5\",\"description\":\"Die PlayStation ist eine Spielkonsole des japanischen Konzerns Sony\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void shouldGetAllProducts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(ProductController.URI).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{\"id\":1,\"title\":\"Konsole\",\"name\":\"Playstation 5\",\"description\":\"Die PlayStation ist eine Spielkonsole des japanischen Konzerns Sony\"},{\"id\":2,\"title\":\"Konsole\",\"name\":\"Nintendo Switch\",\"description\":\"Die Nintendo Switch ist eine Spielkonsole des japanischen Herstellers Nintendo.\"}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }


    @Test
    public void shouldRemoveProducts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(ProductController.URI)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldSaveProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(ProductController.URI).contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"Konsole\",\"name\":\"Xbox 360\",\"description\":\"Test\"}")
            .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":3,\"title\":\"Konsole\",\"name\":\"Xbox 360\",\"description\":\"Test\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }

    @Test
    public void shouldRemoveProductById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(ProductController.URI + "1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldUpdateProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(ProductController.URI).contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"title\":\"Konsole\",\"name\":\"Xbox 720\",\"description\":\"Test\"}")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":3,\"title\":\"Konsole\",\"name\":\"Xbox 720\",\"description\":\"Test\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
    }
}
