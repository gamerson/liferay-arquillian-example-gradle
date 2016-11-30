package add.service.test;

import java.io.File;

import add.service.AddService;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.liferay.shrinkwrap.osgi.api.BndProjectBuilder;

@RunWith(Arquillian.class)
public class AddServiceTest {
	
    @Deployment
    public static JavaArchive create() {
        BndProjectBuilder bndProjectBuilder = ShrinkWrap.create(
            BndProjectBuilder.class);

        bndProjectBuilder.setBndFile(new File("bnd.bnd"));

        bndProjectBuilder.generateManifest(true);

        return bndProjectBuilder.as(JavaArchive.class);
    }

    @Test
    public void testAdd() {
        int result = _addService.add(1, 3);

        Assert.assertEquals(4, result);
    }

    @Inject
    private AddService _addService;

}