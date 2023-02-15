package catFamily;

import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ParameterizedTest {
    private String kindOfAnimal;
    private List typeOfFood;

    public ParameterizedTest(String kindOfAnimal, List typeOfFood) {
        this.kindOfAnimal = kindOfAnimal;
        this.typeOfFood = typeOfFood;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Неизвестный", List.of("Камень", "Земля")}
        };
    }

    @Test
    public void foodAnimalTest() {
        try {
            Feline feline = new Feline();
            List actual = feline.getFood(kindOfAnimal);
            assertEquals(typeOfFood, actual);
        } catch (Exception ex) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
}
