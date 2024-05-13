package meeting.plannner.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SwaggerConfig.class)
public class SwaggerConfigTest {

    @Autowired
    private GroupedOpenApi publicApi;

    @Test
    public void publicApiBeanExists() {
        assertThat(publicApi).isNotNull();
        assertThat(publicApi.getGroup()).isEqualTo("meeting-plannner");
    }
}
