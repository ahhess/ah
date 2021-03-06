// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package bwbvrlt.model;

import bwbvrlt.model.Rlt;
import bwbvrlt.model.RltDataOnDemand;
import bwbvrlt.model.RltIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RltIntegrationTest_Roo_IntegrationTest {
    
    declare @type: RltIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: RltIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: RltIntegrationTest: @Transactional;
    
    @Autowired
    private RltDataOnDemand RltIntegrationTest.dod;
    
    @Test
    public void RltIntegrationTest.testCountRlts() {
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", dod.getRandomRlt());
        long count = Rlt.countRlts();
        Assert.assertTrue("Counter for 'Rlt' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void RltIntegrationTest.testFindRlt() {
        Rlt obj = dod.getRandomRlt();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to provide an identifier", id);
        obj = Rlt.findRlt(id);
        Assert.assertNotNull("Find method for 'Rlt' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Rlt' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void RltIntegrationTest.testFindAllRlts() {
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", dod.getRandomRlt());
        long count = Rlt.countRlts();
        Assert.assertTrue("Too expensive to perform a find all test for 'Rlt', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Rlt> result = Rlt.findAllRlts();
        Assert.assertNotNull("Find all method for 'Rlt' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Rlt' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void RltIntegrationTest.testFindRltEntries() {
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", dod.getRandomRlt());
        long count = Rlt.countRlts();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Rlt> result = Rlt.findRltEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Rlt' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Rlt' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void RltIntegrationTest.testFlush() {
        Rlt obj = dod.getRandomRlt();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to provide an identifier", id);
        obj = Rlt.findRlt(id);
        Assert.assertNotNull("Find method for 'Rlt' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyRlt(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Rlt' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void RltIntegrationTest.testMergeUpdate() {
        Rlt obj = dod.getRandomRlt();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to provide an identifier", id);
        obj = Rlt.findRlt(id);
        boolean modified =  dod.modifyRlt(obj);
        Integer currentVersion = obj.getVersion();
        Rlt merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Rlt' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void RltIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", dod.getRandomRlt());
        Rlt obj = dod.getNewTransientRlt(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Rlt' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Rlt' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Rlt' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void RltIntegrationTest.testRemove() {
        Rlt obj = dod.getRandomRlt();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Rlt' failed to provide an identifier", id);
        obj = Rlt.findRlt(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Rlt' with identifier '" + id + "'", Rlt.findRlt(id));
    }
    
}
