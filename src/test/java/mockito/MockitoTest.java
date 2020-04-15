package mockito;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    @Mock
    MyDataBase dataBaseMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testQuery() {
        ClassToTest classToTest = new ClassToTest(dataBaseMock);
        when(dataBaseMock.query("* from classToTest")).thenReturn(true);
        boolean check = classToTest.query("* from classToTest");
        Assert.assertTrue(check);
    }
    @Test
    public void CustomerReaderTest() {
        Customer sampleCustomer = new Customer("Steve","Jobs");
        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Customer.class, 1L)).thenReturn(sampleCustomer);
        CustomerReader customerReader = new CustomerReader();
        customerReader.setEntityManager(entityManager);
        String fullName = customerReader.findFullName(1L);
        Assert.assertEquals("Steve Jobs",fullName);
    }
}
