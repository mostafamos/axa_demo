package jp.co.axa.apidemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	//Enhance the code in any ways you can see, you are free! Some possibilities:
	//Add tests
	//so im testing that the service is not null and the controller can be tested as well
	@Test
	public void contextLoads() {
		assertNotNull(employeeRepository);
	}

}
