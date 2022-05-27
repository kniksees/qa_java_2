package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CatTest {

    private Cat cat;

    @Mock
    private Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        String sound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(sound, actualSound);
    }

    @Test
    public void getFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat())
                .thenReturn(food);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(food, actualFood);
    }
}