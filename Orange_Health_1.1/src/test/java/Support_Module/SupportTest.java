package Support_Module;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ty.orangehealth.ListenerUtility.ListenerImp;
import com.ty.orangehealth.business_utility.BaseClassTest;
import com.ty.orangehealth.object_repository.HomePage;

@Listeners(ListenerImp.class)
public class SupportTest extends BaseClassTest {
	@Test
	public void verifySupportBtnTest() {
		HomePage hp=new HomePage(driver);
		boolean isDiplay = hp.getSuptBtn().isDisplayed();
		Assert.assertTrue(isDiplay);
	}
}
