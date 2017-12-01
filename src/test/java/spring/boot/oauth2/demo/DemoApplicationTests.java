package spring.boot.oauth2.demo;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.oauth2.demo.entity.UserEntity;
import spring.boot.oauth2.demo.repository.UserEntityRepository;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Log4j
public class DemoApplicationTests {

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Test
	@Rollback(value = false)
	@Transactional
	public void findOne() {
		UserEntity userEntity = userEntityRepository.getOne(1);
		log.info("username: ------ "+userEntity.getUsername());
	}

	@Test
	@Rollback(value = false)
	@Transactional
	public void insert1() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(user.getPassword());
		userEntity.setRole("ADMIN");

		userEntityRepository.save(userEntity);
	}

	@Test
	@Rollback(value = false)
	@Transactional
	public void insert2() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("admin");
		userEntity.setPassword("admin");
		userEntity.setRole("ADMIN");

		userEntityRepository.save(userEntity);
	}

}
