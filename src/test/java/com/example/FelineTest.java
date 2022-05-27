package com.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)

public class FelineTest {
    private final int firstNumber;
    private final int expected;

    private Feline feline = new Feline();

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Animal animal;

    public FelineTest(int firstNumber, int expected) {
        this.firstNumber = firstNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},

        };
    }

    @Test
    public void testGetKittensWithPassingValue() {
        Feline feline1 = new Feline();
        int actual = Feline.getKittens(firstNumber);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник"))
                .thenReturn(food);
        List<String> actualFood = animal.getFood("Хищник");
        Assert.assertEquals(food, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        String family = "Кошачьи";
        Assert.assertEquals(family, feline.getFamily());

    }

    @Test
    public void getKittens() {
        Assert.assertEquals(1, feline.getKittens());
    }

//    @Test
//    public void testGetKittens() {
//        int countOfKittens = 2;
//        Assert.assertEquals(countOfKittens, feline.getKittens(countOfKittens));
//    }
}