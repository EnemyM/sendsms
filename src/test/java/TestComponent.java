import com.sv.sendsms.config.ApplicationContext;
import com.sv.sendsms.model.ResponseEntity;
import com.sv.sendsms.service.SendSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by anton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContext.class})
@WebAppConfiguration
public class TestComponent {

    @Autowired
    SendSmsService sendSmsService;

    /**
     * successful send sms message case  to existing phone number
     */
    @Test
    public void testSendSms() {
        ResponseEntity responseEntity = (ResponseEntity) sendSmsService.sendSms("+380665691317", "Test message " + System.currentTimeMillis());
        assertEquals(responseEntity.getCode(), new Integer(200));
    }
}
