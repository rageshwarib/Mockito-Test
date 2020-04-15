package mockito;

public class CustomerReader {
    private EntityManager entitymanager;

    public void setEntityManager(EntityManager entityManager) {
        this.entitymanager = entityManager;
    }

    public String findFullName(long id) {
     Customer customer = this.entitymanager.find(Customer.class, id);
     return customer.firstName + " "+ customer.lastName;
    }

}
