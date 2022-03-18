import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pruebaJM.Dependency;
import pruebaJM.SubDependency;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DependencyTest {



    @Mock
    private SubDependency subDependency;
    private Dependency dependency;

    @Before
    public void setupMock() {
        subDependency = mock(SubDependency.class);
        dependency = new Dependency(subDependency);
    }

    @Test
    public void testSubdependency(){
        when(subDependency.getClassName()).thenReturn("Hola 2");
        assertEquals("Hola 2", dependency.getSubdepedencyClassName());
    }

}
