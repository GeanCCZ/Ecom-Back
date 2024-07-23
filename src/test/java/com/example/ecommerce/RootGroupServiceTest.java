import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ecommerce.domain.dto.RootGroupDTO;
import com.example.ecommerce.service.RootGroupService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RootGroupServiceTest {

    @InjectMocks
    private RootGroupService rootGroupService;

    @Test
    public void testRootGroupCreate(){
        RootGroupDTO newRootGroup = new RootGroupDTO(null, "RootGroup", 1, null, null, null);

        RootGroupDTO createdRootGroup = this.rootGroupService.create(newRootGroup);

        assertEquals(newRootGroup.display_name(), createdRootGroup.display_name());
        assertEquals(newRootGroup.sequence(), createdRootGroup.sequence());
        assertEquals(newRootGroup.image(), createdRootGroup.image());
        assertEquals(newRootGroup.productList(), createdRootGroup.productList());
        assertEquals(newRootGroup.category(), createdRootGroup.category());

    }

    @Test
    public void testRootGroupUpdate(){
        RootGroupDTO newRootGroup = new RootGroupDTO(null, "RootGroup", 1, null, null, null);

        RootGroupDTO createdRootGroup = this.rootGroupService.create(newRootGroup);

        RootGroupDTO updateRootGroupDTO = new RootGroupDTO(createdRootGroup.id(), "RootGroup", 2, null, null, null);

        RootGroupDTO updatedRootGroup = this.rootGroupService.update(createdRootGroup.id(), updateRootGroupDTO);

        assertEquals(updateRootGroupDTO.display_name(), updatedRootGroup.display_name());
        assertEquals(updateRootGroupDTO.sequence(), updatedRootGroup.sequence());
        assertEquals(updateRootGroupDTO.image(), updatedRootGroup.image());
        assertEquals(updateRootGroupDTO.productList(), updatedRootGroup.productList());
        assertEquals(updateRootGroupDTO.category(), updatedRootGroup.category());
    }
}
