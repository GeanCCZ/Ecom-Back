import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.UserDTO;
import com.example.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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

        assertEquals(newUser.firstName(), createdUser.firstName());
        assertEquals(newUser.lastName(), createdUser.lastName());
        assertEquals(newUser.email(), createdUser.email());
        assertEquals(newUser.phone(), createdUser.phone());
        assertEquals(newUser.password(), createdUser.password());
        assertEquals(newUser.role(), createdUser.role());
        assertEquals(newUser.addresses(), createdUser.addresses());
        assertEquals(newUser.orderList(), createdUser.orderList());
        assertEquals(newUser.reviewList(), createdUser.reviewList());
    }

    @Test
    public void testUserUpdate() {
        UserDTO newUser = new UserDTO(null, null, null, null, null, null, "G.", "Son", "gson@gmail.com", "(44) 911111111", "null");

        UserDTO createdUser = this.userService.create(newUser);

        UserDTO updateUserDTO = new UserDTO(createdUser.id(), null, null, null, null, null, "Thunder", "Son", "thunder@gmail.com", "(44) 9452175131", "null");

        UserDTO updatedUser = this.userService.update(createdUser.id(), updateUserDTO);

        assertEquals(updateUserDTO.firstName(), updatedUser.firstName());
        assertEquals(updateUserDTO.lastName(), updatedUser.lastName());
        assertEquals(updateUserDTO.email(), updatedUser.email());
        assertEquals(updateUserDTO.phone(), updatedUser.phone());
        assertEquals(updateUserDTO.password(), updatedUser.password());
        assertEquals(updateUserDTO.role(), updatedUser.role());
        assertEquals(updateUserDTO.addresses(), updatedUser.addresses());
        assertEquals(updateUserDTO.orderList(), updatedUser.orderList());
        assertEquals(updateUserDTO.reviewList(), updatedUser.reviewList());

    }
}
