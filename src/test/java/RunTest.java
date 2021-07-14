import com.keeggo.conexao.Utilidades;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/keeggo/features",
        glue = "com.keeggo.steps",
        plugin = "json:target//cucumber-json/cucumber.json")
public class RunTest {
}

