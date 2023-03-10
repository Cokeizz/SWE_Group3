package nl.tudelft.jpacman.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class SelectConfigureUITest extends SelectConfigureUI {
    SelectConfigureUI selectConfigureUI;
    @BeforeEach
    void setUp() {
        selectConfigureUI = new SelectConfigureUI();
    }
    @Test
    public void testSelectConfigureUIConstructor() {
        assertThat(selectConfigureUI).isNotNull();



    }

}
