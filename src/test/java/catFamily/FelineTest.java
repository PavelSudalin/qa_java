package catFamily;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void felineKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = feline.getKittens();
        assertEquals("Некорректно указано количество котят", 1, actual);
    }

    @Test
    public void felineFamilyTest() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }

    @Test
    public void felineEatMeatTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFoodList = feline.eatMeat();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Данный рацион не соответствует желанию семейству кошачих", expected, actualFoodList);
    }
}
