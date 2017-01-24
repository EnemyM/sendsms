import com.fasterxml.jackson.databind.ObjectMapper;
import com.sv.sendsms.config.ApplicationContext;
import com.sv.sendsms.model.SendSmsData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 * Created by anton
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContext.class})
@WebAppConfiguration
public class MockTest {

    private MockMvc mockMvc;

    private String url = "/send/sms";

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

    }

    @Test
    public void testSendSmsMock() throws Exception {
        MvcResult result = mockMvc.perform(post(new URI(url))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(new ObjectMapper().writeValueAsString(new SendSmsData("+380665691317", "Test smpp service"))))
                .andReturn();

        assertTrue(String.valueOf(result.getAsyncResult()).contains("200"));
    }
}
