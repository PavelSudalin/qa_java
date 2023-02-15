package catFamily;

import com.example.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void lionHasManeTrueTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Пол льва не соответствует ожидаемому", expected, actual);
    }

    @Test
    public void lionHasManeFalseTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Пол льва не соответствует ожидаемому", expected, actual);
    }

    @Test
    public void foodLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Assert.assertEquals("Данный рацион не соответствует желанию льва", expected, actual);
    }

    @Test
    public void kittensLionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        Assert.assertEquals("Некорректно указано количество котят", 1, actual);
    }
}
