package mockito;

public class ClassToTest {

    private final MyDataBase myDatabase;

    public ClassToTest(MyDataBase myDataBase) {
        this.myDatabase = myDataBase;
    }
    public boolean query(String query) {
        return this.myDatabase.query(query);
    }
}
