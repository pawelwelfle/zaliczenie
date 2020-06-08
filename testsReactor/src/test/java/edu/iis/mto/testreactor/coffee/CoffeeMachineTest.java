package edu.iis.mto.testreactor.coffee;

import static edu.iis.mto.testreactor.coffee.CoffeType.ESPRESSO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import edu.iis.mto.testreactor.coffee.milkprovider.MilkProvider;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine;
    @Mock
    private Grinder grinder;
    @Mock
    private CoffeeReceipes coffeeReceipes;
    @Mock
    private MilkProvider milkProvider;
    private CoffeOrder order;

    @BeforeEach
    void setUp() throws Exception {
        coffeeMachine = new CoffeeMachine(grinder, milkProvider, coffeeReceipes);
    }

    @Test
    void checkIfCoffeCanBeCreate() {
        Coffee coffee = new Coffee;
        CoffeeReceipe receipe = coffeeReceipes.getReceipe(ESPRESSO);
        grinder.grind(CoffeeSize.SMALL);

         CoffeOrder espressoCoffeOrder = CoffeOrder.builder()
                .withSize(CoffeeSize.SMALL)
                .withType(ESPRESSO)
                .build();

        assertEquals(espressoCoffeOrder, receipe);
    }

    @Test
    void checkIfCoffeCanBeDone(){
        coffeeMachine.make(order.builder()
        .withSize(CoffeeSize.SMALL)
        .withType(CoffeType.ESPRESSO)
        .build());

        verify(coffeeMachine).make();
    }

    @Test
    public void itCompiles() {
        assertThat(true, Matchers.equalTo(true));
    }



}
