import config.DriverBase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(PersonalInfoTests.class)
public class TestSuite {

    @BeforeClass()
    public static void instantiateDriverObject() {
        DriverBase.instantiateDriverObject();
    }

    @AfterClass()
    public static void closeDriverObjects() {
       DriverBase.closeDriverObjects();
    }
}