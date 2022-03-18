import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pruebaJM.Dependency;

import static org.mockito.Mockito.*;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    //analizamos el uso del objeto con verify:
    @Test
    public void testSimpleVerify() {
        // nunca se ha ejecutado:
        verify(dependency, never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();
    //exactamente una, (cant pasada por parametro):
        verify(dependency, times(1)).getClassNameUpperCase();
    //como minimo una vez(la cantidad la pasamos por parametro):
        verify(dependency, atLeast(1)).getClassNameUpperCase();
    //como maximo dos veces(la cantidad la pasamos por parametro):
        verify(dependency, atMost(2)).getClassNameUpperCase();
    }

    //pruebas times
    @Test
    public void testParameters(){
        dependency.addTwo(3);

        //verifica que se haya usado una vez, con el parametro 3:
        verify(dependency, times(1)).addTwo(3);

        dependency.addTwo(4);

        //verifica que se haya usado 2 veces, con cualquier parametro:
        verify(dependency, times(2)).addTwo(anyInt());

    }

}
