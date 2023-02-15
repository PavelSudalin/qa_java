package catFamily;

import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void gettingCatFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыбы");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыбы"));
        List<String> actual = cat.getFood();
        Assert.assertEquals("Данный рацион не соответствует желанию кота", expected, actual);
    }
    @Test
    public void getCatSoundTest() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals("Кот издает другой звук", expected, actual);
    }
}
