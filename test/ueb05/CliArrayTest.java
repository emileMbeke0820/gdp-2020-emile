package ueb05;

import org.hamcrest.CoreMatchers;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;


import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class CliArrayTest  {

    @Test
    public void shouldParseParameterStringToArraySize() {
        //given
        final @NotNull String[] parameters = asArgs("12");

        //when
        final double[] prices = new CliArray(parameters, asInput("1.5")).getPrices();

        //then
        assertEquals(prices.length, 12);
    }

    @Test
    public void shouldFailForInvalidArraySize() {
        //given
        final @NotNull String[] parameters = asArgs("huhu");

        //when
        try {
            new CliArray(parameters, asInput("1.5"));

            //then
            fail("Expected an exception for invalid input");
        } catch (CliArray.InvalidArraySizeException e) {
            // this is the expected behaviour
        }
    }

    @Test
    public void shouldFailForMissingParameter() {
        //given
        final @NotNull String[] parameters = new String[0];

        //when
        try {
            new CliArray(parameters, asInput("1.5"));

            //then
            fail("Expected an exception for invalid input");
        } catch (CliArray.InvalidArraySizeException e) {
            // this is the expected behaviour
        }
    }

    @Test
    public void shouldReadPrizesUntilArrayIsFull() {
        //given
        final ByteArrayInputStream in = asInput("1\n2\n3\n4\n5\n6\n7\n8\n9");

        //when
        final CliArray cliArray = new CliArray(asArgs("6"), in);

        cliArray.readPrices();
        final double[] prices = cliArray.getPrices();

        //then
        assertThat(prices, CoreMatchers.equalTo(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}));
    }

    @Test
    public void shouldReadPrizesUntilXIsInput() {
        //given
        final ByteArrayInputStream in = asInput("1\n2\n3\nx\n5\n6\n7\n8\n9");

        //when
        final CliArray cliArray = new CliArray(asArgs("6"), in);

        cliArray.readPrices();
        final double[] prices = cliArray.getPrices();

        //then
        assertThat(prices, CoreMatchers.equalTo(new double[]{1.0, 2.0, 3.0, 0.0, 0.0, 0.0}));
    }

    @NotNull
    private String[] asArgs(String s) {
        return new String[]{s};
    }

    @NotNull
    private ByteArrayInputStream asInput(String s) {
        return new ByteArrayInputStream(s.getBytes());
    }
}