package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class VoitureTest {

    private Voiture v1;
    @BeforeEach
    void creerVoiture(){
        v1 = new Voiture();
    }

    @Test
    void modifierId(){
        v1.setId(123);

        int testId = v1.getId();
        assertEquals(testId,123);
    }

    @Test
    void modifierMarque(){
        v1.setMarque("Mercedes");

        String testMarque = v1.getMarque();
        assertEquals(testMarque, "Mercedes");
    }

    @Test
    void modifierPrix(){
        v1.setPrix(1000);

        int prixTest = v1.getPrix();
        assertEquals(prixTest,1000);
    }

    @Test
    void testToString(){
        Voiture v2 = new Voiture("Audi",2000);
        v2.setId(9);
        String expectedString = "Car{marque='Audi', prix=2000, id=9}";
        assertEquals(v2.toString(),expectedString );
    }


}
