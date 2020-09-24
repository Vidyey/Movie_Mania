import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.Capgemini.Movie_Mania.Project.service.MovieService;


@RunWith(SpringRunner.class)
@SpringBootTest
class AdminTesting {
	@Autowired
	private MovieService movieService;

	@Test
	void test() {
		
	}

	@Test
	@Rollback(true)
	public void addMovieTest()
	{
		
	}
	
}
