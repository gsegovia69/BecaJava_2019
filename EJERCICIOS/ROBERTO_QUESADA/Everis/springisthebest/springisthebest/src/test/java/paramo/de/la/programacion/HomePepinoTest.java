package paramo.de.la.programacion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomePepinoController.class)
public class HomePepinoTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePepino() throws Exception {

		mockMvc.perform(get("/"))

				.andExpect(status().isOk())

				.andExpect(view().name("homepepino"));
				
			
	}

}
