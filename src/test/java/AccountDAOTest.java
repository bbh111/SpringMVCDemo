import com.springmvc.entities.Account;
import com.springmvc.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;


public class AccountDAOTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void itShouldShowAllAccount(){
       List<Account> list =  accountService.getAccountDAO().findAll();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }
}
