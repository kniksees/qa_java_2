package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.when;


public class LionTest {
    private Lion lion;
    private Lion lionOrlioness;


    @Mock
    private static Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    public LionTest() {
    }


    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }


    @Test
    public void getKittens() {
        when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void haveMane() {
        boolean mane = true;
        boolean actualMane = lion.doesHaveMane();
        Assert.assertEquals(mane, actualMane);
    }

    @Test
    public void notHaveMane() throws Exception {
        lionOrlioness = new Lion(feline, "Самка");
        boolean mane = false;
        boolean actualMane = lionOrlioness.doesHaveMane();
        Assert.assertEquals(mane, actualMane);
    }

    @Test
    public void exceptionHaveMane() {
        Exception e = Assert.assertThrows("", Exception.class, () -> new Lion(feline, "???"));
        Assert.assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник"))
                .thenReturn(food);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(food, actualFood);
    }
}