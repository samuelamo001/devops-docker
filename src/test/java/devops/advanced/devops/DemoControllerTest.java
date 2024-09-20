package devops.advanced.devops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(DemoController.class)
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void welcomeShouldReturnListOfMessages() throws Exception {

        mockMvc.perform(get("/api/v1/home"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Welcome to the new!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("Explore the possibilities of Spring Boot."))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value("Discover the power of DevOps."))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3]").value("Embrace the future of technology!"));
    }
}

