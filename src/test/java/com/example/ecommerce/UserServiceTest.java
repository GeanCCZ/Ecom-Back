import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void testUserCreate(){
        UserDTO newUser = new UserDTO(null, null, null, null, null, null, "G.", "Son", "gson@gmail.com", "(44) 911111111", "null");

        UserDTO createdUser = this.userService.create(newUser);

        assertEquals(newUser.first_name(), createdUser.first_name());
        assertEquals(newUser.last_name(), createdUser.last_name());
        assertEquals(newUser.email(), createdUser.email());
        assertEquals(newUser.phone(), createdUser.phone());
        assertEquals(newUser.password(), createdUser.password());
        assertEquals(newUser.role(), createdUser.role());
        assertEquals(newUser.address(), createdUser.address());
        assertEquals(newUser.orders(), createdUser.orders());
        assertEquals(newUser.reviewList(), createdUser.reviewList());
    }

    @Test
    public void testUserUpdate() {
        UserDTO newUser = new UserDTO(null, null, null, null, null, null, "G.", "Son", "gson@gmail.com", "(44) 911111111", "null");

        UserDTO createdUser = this.userService.create(newUser);

        UserDTO updateUserDTO = new UserDTO(createdUser.id(), null, null, null, null, null, "Thunder", "Son", "thunder@gmail.com", "(44) 9452175131", "null");

        UserDTO updatedUser = this.userService.update(createdUser.id(), updateUserDTO);

        assertEquals(updateUserDTO.first_name(), updatedUser.first_name());
        assertEquals(updateUserDTO.last_name(), updatedUser.last_name());
        assertEquals(updateUserDTO.email(), updatedUser.email());
        assertEquals(updateUserDTO.phone(), updatedUser.phone());
        assertEquals(updateUserDTO.password(), updatedUser.password());
        assertEquals(updateUserDTO.role(), updatedUser.role());
        assertEquals(updateUserDTO.address(), updatedUser.address());
        assertEquals(updateUserDTO.orders(), updatedUser.orders());
        assertEquals(updateUserDTO.reviewList(), updatedUser.reviewList());

    }
}
